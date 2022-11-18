import os
import random
from firebase_admin import credentials, initialize_app, storage, firestore
from dotenv import load_dotenv

load_dotenv()

# Path de las credenciales del FireBase"
creden = os.environ["FIREBASE_CREDENTIALS_PATH"]

# Path de la carpeta de videos
path = os.environ["VIDEO_DIRECTORY_PATH"]

# Storage bucket de la app
app_storage_bucket = os.environ["APP_STORAGE_BUCKET"]

cred = credentials.Certificate(creden)
initialize_app(cred, {'storageBucket': app_storage_bucket})
db = firestore.client()

dir_list = os.listdir(path)

for sub_dir in dir_list:

    try:

        files = os.listdir(path + "//" + sub_dir)

        category = sub_dir.split("_")[1]
        doc_ref = db.collection("categories").add({"title":category})

        quizz_collection = doc_ref[1].collection("quizz").add({"title":f"Quizz {category}","description":f"Preguntas para practicar sobre {category}"})

        quiz_length = 4
        questions = [[]]
        index=0
        number_of_quiz=0

        random.shuffle(files)

        for i,file in enumerate(files):
            if index == quiz_length:
                number_of_quiz+=1
                index=0
                questions.append([])
            questions[number_of_quiz].append(file)
            index+=1

        extra_past=[]

        for quizz in questions:

            media_options = []
            options=[]

            for file in quizz:
                filePath = path + "//" + sub_dir + "//" + file

                bucket = storage.bucket()
                blob = bucket.blob(sub_dir + "/" + file)
                blob.upload_from_filename(filePath)

                blob.make_public()

                media = blob.public_url
                media_options.append(media)

                name = file.split(".")[0]
                name = name.split("_")[0]

                options.append(name)

                description = category + " " + name

                word_collection = doc_ref[1].collection("words").add({"name":name,"description":description,"media":media})
            
            correct_answer = random.randint(0, len(options)-1)
            media=media_options[correct_answer]

            cont=0
            while (len(options) < 4):
                if extra_past == []:
                    break
                if cont >= len(extra_past):
                    cont = 0 
                options.append(extra_past[cont])
                cont+=1
            
            extra_past = options

            quizz_collection[1].collection("questions").add({"prompt":f"Indica la opción correcta","answer":correct_answer,"options":options,"media":media})

        print(sub_dir + " Done!")

    except:
        continue