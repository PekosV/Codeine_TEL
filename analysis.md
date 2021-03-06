# Ανάλυση Απαιτήσεων και Προδιαγραφών Πλατφόρμας Scrum

Περιεχόμενα :
- [Σχεδιασμός Εφαρμογής και Απαιτήσεις](#Σχεδιασμός-Εφαρμογής-και-Απαιτήσεις)
  - [Λειτουργικές Απαιτήσεις](#Λειτουργικές-Απαιτήσεις)
  - [Μη Λειτουργικές Απαιτήσεις](#Μη-Λειτουργικές-Απαιτήσεις)
  - [Σενάρια Χρήσης με Uml](#Σενάρια-Χρήσης-με-Uml)
  - [Wireframes](#Wireframes)
- [Τεχνικές Προδιαγραφές](#Τεχνικές-Προδιαγραφές)
  - [Μοντέλο Οντοτήτων Συσχετίσεων Βάσης Δεδομένων](#Μοντέλο-Οντοτήτων-Συσχετίσεων-Βάσης-Δεδομένων)

### Σχεδιασμός Εφαρμογής και Απαιτήσεις
### Λειτουργικές και μη Λειτουργικές Απαιτήσεις

| #             | Ομάδες Χρηστών   |  Περιγραφή Απαιτήσεων  | Προδιαγραφές | Αναγκαιότητα υλοποίησης |
| ------------- |------------------| -----------------------|--------------|-------------------------|
| 1 |Πελάτης| Δυνατότητα παρακολούθησης εξέλιξης του προϊόντος | Διεπαφή με τις πληροφορίες για την κατάσταση που βρίσκεται το Project όπως ώρες που έχουν καταναλωθεί , ώρες που απομένουν ,ποσοστό ολοκληρωσης κλπ | Major |
| 2 | Χρήστης | Δυνατότητα ενημέρωσης για προδιαγραφές , αλλαγες , υπενθυμίσεις κλπ | Δημιουργία News Feed που να παρουσιάζει προσωποποιημένο Content για τα Project στα οποία εργάζεται ο χρήστης και Notifications για υπενθημήσεις για deadlines και σημαντικά Issues | Major |
| 3 | Όλοι | Απαίτηση για επίπεδα αφαίρεσης στις δυνατότητες της πλατφόρμας ώστε απλοί χρήστες και διαχειριστές ή πελάτες να  έχουν πρόσβαση σε διαφορετικές πληροφορίες | Σχεδιασμός που να επιτρέπει την διάχυση πληροφορίας ανάμεσα στα επίπεδα των χρηστών και περιορισμός δυνατοτήτων με βάση τα access rights του καθενός | Major |
| 4 |Πέλατης | Απαίτηση για δυνατότητα απόκτησης premium λογαριασμού για την δημιουργία και διαχείριση project | Ύπαρξη επιλογής για πληρωμή προς απόκτηση premium λογαριασμού με χρήση πιστωτικής κάρτας ή Paypal | Major |
| 5 | Πέλατης |  Απαίτηση για δυνατότητα απόκτησης premium λογαριασμού για την δημιουργία και διαχείριση ομάδας χρηστών  | Ύπαρξη επιλογής δημιουργίας ομάδας και δυνατότητας προσθήκης μελών/χρηστών | Major |
| 6 | Πέλατης |  Δυνατότητα προσθήκης/αφαίρεσης μελών στην/απο ομάδα | Ύπαρξη επιλογής για προσθήκη ή αφαιρεση μέλους   | Major |
| 7 | Πέλατης |  Δυνατότητα επιλογής ανάθεσης ρόλων για κάθε μέλος της ομάδας | Ύπαρξη dropDown menu με επιλογές για την ανάθεση κάθε ρόλου στα μέλη  | Major |
| 8 | Χρήστης | Δυνατότητα εγγραφής στην πλατφόρμα  | Ύπαρξη φόρμας προς συμπλήρωση για εγγραφή του χρήστη με το username, email και το κωδικό κ.α | Major |
| 9 | Χρήστης | Δυνατότητα εισόδου του χρήστη στην πλατφόρμα  | Ύπαρξη φόρμας ελέγχου προς συμπλήρωση για είσοδο χρήστη με το username και το κωδικό | Major |
| 10 | Χρήστης | Δυνατότητα εξόδου του χρήστη στην πλατφόρμα  | Ύπαρξη επιλογής για έξοδο | Major |
| 11 | Χρήστης | Δυνατότητα επανάκτησης κωδικού πρόσβασης | Ύπαρξη επιλογής για επανάκτηση κωδικού πρόσβασης με χρήση του προσωπικού email | Major |
| 12 | Χρήστης | Δυνατότητα αποδοχής πρόσκλησης για συμμετοχή σε project και ομάδες | Ύπαρξη Notifications που αφορά την πρόσκληση και επιλογη αποδοχής ή απόρριψης | Major |
| 13 | Χρήστης | Δυνατότητα επεξεργασίας των προσωπικών δεδομένων και προτιμήσεων του προφίλ | 'Υπαρξη φόρμας επεξεργασίας προφίλ | Major |
| 14 | Χρήστης | Δυνατότητα αναζήτησης περιεχόμενου της πλατφόρμας | Ύπαρξη ενσωματωμένης μηχανής αναζήτησης | Major |


### Σενάρια Χρήσης με Uml
![Use Case image](https://github.com/PekosV/Codeine_TEL/blob/master/img/UseCase3.jpg)
### Wireframes

**Sign Up**
![Sign Up](https://github.com/PekosV/Codeine_TEL/blob/master/Wireframes%20PNG/SignUp.png)

**HomePage**
![Sign Up](https://github.com/PekosV/Codeine_TEL/blob/master/Wireframes%20PNG/HomePage.png)

**Edit My account**
![Sign Up](https://github.com/PekosV/Codeine_TEL/blob/master/Wireframes%20PNG/EditMyAccount.png)

**Create Project**
![Sign Up](https://github.com/PekosV/Codeine_TEL/blob/master/Wireframes%20PNG/CreateProject.png)

**FAQ**
![Sign Up](https://github.com/PekosV/Codeine_TEL/blob/master/Wireframes%20PNG/FAQ.png)

**Project**
![Sign Up](https://github.com/PekosV/Codeine_TEL/blob/master/Wireframes%20PNG/Project.png)

**Issues**
![Sign Up](https://github.com/PekosV/Codeine_TEL/blob/master/Wireframes%20PNG/Issues.png)

**Epic**
![Sign Up](https://github.com/PekosV/Codeine_TEL/blob/master/Wireframes%20PNG/Epic.png)

**Join Project**
![Sign Up](https://github.com/PekosV/Codeine_TEL/blob/master/Wireframes%20PNG/JoinProject.png)

**Join Team**
![Sign Up](https://github.com/PekosV/Codeine_TEL/blob/master/Wireframes%20PNG/JoinTeam.png)

**My Projects**
![Sign Up](https://github.com/PekosV/Codeine_TEL/blob/master/Wireframes%20PNG/MyProjects.png)

**My Teams**
![Sign Up](https://github.com/PekosV/Codeine_TEL/blob/master/Wireframes%20PNG/MyTeams.png)

**Project Owner** 
![Sign Up](https://github.com/PekosV/Codeine_TEL/blob/master/Wireframes%20PNG/ProjectOwner.png)

**Sprint**
![Sign Up](https://github.com/PekosV/Codeine_TEL/blob/master/Wireframes%20PNG/Sprint.png)

**Story**
![Sign Up](https://github.com/PekosV/Codeine_TEL/blob/master/Wireframes%20PNG/Story.png)

**Sub-Tasks**
![Sign Up](https://github.com/PekosV/Codeine_TEL/blob/master/Wireframes%20PNG/Sub-tasks.png)

**Tasks**
![Sign Up](https://github.com/PekosV/Codeine_TEL/blob/master/Wireframes%20PNG/Tasks.png)

**Team Creation**
![Sign Up](https://github.com/PekosV/Codeine_TEL/blob/master/Wireframes%20PNG/TeamCreation.png)

**Team Member Owner**
![Sign Up](https://github.com/PekosV/Codeine_TEL/blob/master/Wireframes%20PNG/TeamMemberOwner.png)

**Team Member Simple**
![Sign Up](https://github.com/PekosV/Codeine_TEL/blob/master/Wireframes%20PNG/TeamMemberSimple.png)



### Τεχνικές Προδιαγραφές
### Μοντέλο Οντοτήτων Συσχετίσεων Βάσης Δεδομένων

**Database Schema**

![Sign Up](https://github.com/PekosV/Codeine_TEL/blob/master/teldatabase.png)

