To run this project locally, follow these steps:

Clone the repository: git clone https://github.com/KrushnakantBhabhda/LearningNavigator.git
cd LearningNavigator


Database Configuration:

Install MySQL and create a database named learning_navigator.
Update application.properties with your MySQL username and password.

Run the Application: ./gradlew bootRun
The application will start at http://localhost:8080.

API Endpoints:

Students:
GET /students: Retrieve all students.
POST /students: Create a new student.
GET /students/{id}: Retrieve a student by ID.
DELETE /students/{id}: Delete a student by ID.
Subjects:
GET /subjects: Retrieve all subjects.
POST /subjects: Create a new subject.
GET /subjects/{id}: Retrieve a subject by ID.
DELETE /subjects/{id}: Delete a subject by ID.

Exams:
GET /exams: Retrieve all exams.
POST /exams: Create a new exam.
GET /exams/{id}: Retrieve an exam by ID.
DELETE /exams/{id}: Delete an exam by ID.

Register a student for the exam 
Post /register/exams/{examId}/register/{studentId}
