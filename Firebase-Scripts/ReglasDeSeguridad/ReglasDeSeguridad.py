rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
  	function isAdmin(request) {
  		return request.auth.token.admin == true;
  	}
    
    match /users/{user} {
    	allow read: if request.auth.uid == user;
      allow write: if isAdmin(request);
      allow update: if request.auth.uid == user && (request.resource.data.diff(resource.data).affectedKeys()
        .hasOnly(['consultedWords', 'completedLevels']));
      
      match /events/{event} {
      	allow read: if isAdmin(request);
        allow write: if request.auth.uid == user || isAdmin(request);
      }
    }
    
    match /events/{event} {
      	allow read: if isAdmin(request);
        allow write: if request.auth.uid == request.resource.data.uid || isAdmin(request);
    }
    
    match /categories/{category} {
    	allow read: if true;
      allow write: if isAdmin(request);
      
      match /words/{word} {
      	allow read: if true;
        allow write: if isAdmin(request);
      }
      
      match /quizz/{quiz} {
      	allow read: if true;
        allow write: if isAdmin(request);
        
        match /questions/{q} {
        	allow read: if true;
          allow write: if isAdmin(request);
        }
      }
    }
    
    match /{document=**} {
      allow read, write: if false;
    }
  }
}
