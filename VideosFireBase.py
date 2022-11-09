import os
from firebase_admin import credentials, initialize_app, storage, firestore

print("Ingresar Path de las credenciales del FireBase")
creden = str(input(">>> "))

print("\nIngresar Path de la carpeta de videos")
path = input(">>> ")

print("")

cred = credentials.Certificate(creden)
initialize_app(cred, {'storageBucket': 'ademanos-f242e.appspot.com'})
db = firestore.client()

dir_list = os.listdir(path)

for sub_dir in dir_list:
    
    files = os.listdir(path + "//" + sub_dir)

    doc_ref = db.collection("categories").add({"title":sub_dir.split("_")[1]})
    
    for file in files:
        
        filePath = path + "//" + sub_dir + "//" + file

        bucket = storage.bucket()
        blob = bucket.blob(sub_dir + "/" + file)
        blob.upload_from_filename(filePath)

        blob.make_public()

        media = blob.public_url


        name = file.split(".")[0]
        name = name.split("_")[0]

        description = sub_dir.split("_")[1] + " " + name

        temp = doc_ref[1].collection("words").add({"name":name,"description":description,"media":media})

    print(sub_dir + " Done!")
    