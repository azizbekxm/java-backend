**SQL task**


Create a database from the attached sql script and write the following queries:  
1. Select all primary skills that contain more than one word (please note that both ‘-‘ and ‘ ’ could be used as a separator) – 7 points. 
2. Select all students who does not have second name (it is absent or consists from only one letter/letter with dot) – 7 points. 
3. Select number of students passed exams for each subject and order result by number of student descending. – 7 points. 
4. Select number of students with the same exam marks for each subject. – 7 points. 
5. Select students who passed at least two exams for different subject. – 7 points. 
6. Select students who passed at least two exams for the same subject. – 7 points. 
7. Select all subjects which exams passed only students with the same primary skills. – 7 points. 
8. Select all subjects which exams passed only students with the different primary skills. It means that all students passed the exam for the one subject must have different primary skill. – 10 points. 
9. Select students who does not pass any exam using each the following operator: – 10 points. 
    * Outer join 
    * Subquery with ‘not in’ clause 
    * Subquery with ‘any ‘ clause 
Check which approach is faster for 1000, 10K, 100K exams and 10, 1K, 100K students 
10. Select all students whose average mark is bigger than overall average mark. – 7 points. 
11. Select top 5 students who passed their last exam better than average students. – 7 points. 
12. Select biggest mark for each student and add text description for the mark (use COALESCE and WHEN operators)  – 7 points. 
    * In case if student has not passed any exam ‘not passed' should be returned.  
    * If student mark is 1,2,3 – it should be returned as ‘BAD’ 
    * If student mark is 4,5,6 – it should be returned as ‘AVERAGE’ 
    * If student mark is 7,8 – it should be returned as ‘GOOD’ 
    * If student mark is 9,10 – it should be returned as ‘EXCELLENT’  
13. Select number of all marks for each mark type (‘BAD’, ‘AVERAGE’,…) – 10 points. 


Result of your task is  
* SQL file that will show to your mentor and tutor how you did your homework 
* Query optimization investigation is provided as a separate document 
