># **Preparation**
>-	Setup Linux OS (it can be your own Linux based OS or setup it by installing VirtualBox +   Unix based OS on your Windows machine)   
>-	All your input/output from console should be sent to your mentor after all task completion. So, take care about it before starting your task (think how will you get this information)  

# **Main**
1. **Simple commands** *(20 points)*
    -	Print 'CDP JaMP' on the screen  
    -	Print OS information (name, kernel, etc.)  
    -	Print current path  
    -	Print current date  
    -  	Print current time  
2. **Navigation commands** *(20 points)*
    -	Print full path of your home directory  
    -	Go to home directory  
    -	Get all files in the current directory  
    -	Create new folder 'test'  
    -	Rename 'test' folder to 'newTest'  
    -	Go to 'newTest' folder  
    -	Get current date and save the output to the file 'nowFile'  
    -	Copy file 'nowFile'. New file name is 'copyOfNowFile'  
    -	Get all files information (including date of creation, who created, etc.)  
    -	Create empty file 'emptyFile' without text editor  
    -	Go up(back to home)  
    -	Delete 'newTest' folder emtyFile
3. **Permissions** *(20 points)* 
    -	Get all files in the current directory  
    -	Create new folder 'permission'  
    -	Go to this directory  
    -	Create new file 'secretFile' with content 'This is very secret info'  
    -	Change permission of this file so that no one can read it.  
    -	Get list of files in the current directory with permissions information  
    -	Try to read information from file  
4. **Manage users and groups** *(20 points)* 
    -	Print current user 
    -	Change your password 
    -	Add new users ‘readUser’ and ‘editUser’ 
    -	Add new groups ‘readers’ and ‘editors’ 
    -	Add user ‘readUser’ to the group ‘readers’ and ‘editUser’ to the groups ‘editors’ 
    -	Create ‘read’ ‘edit’ directories with any files inside (it can be files from previous tasks) 
    -	Give groups permissions to directories (only read access for ‘readers‘ group to the ‘read’ directory and full  access for ‘editors‘ group to the ‘edit’ directory) 
    -	Try to switch between users and read information from files  
5. **Processes**  *(20 points)* 
    -	Get list of all running processes  
    -	Get list of all running processes with CPU and memory usage  
    -	Get list of all running processes of your user  
    -  	Get dynamic real-time view list of processes that are currently being managed by the Linux kernel (CPU, Memory Usage, etc.).  
    -	Sort previous list by Memory Usage.  

# **Extra miles**

**Sort task**. Create script that will create txt file with random 5000000 numbers between 0 and 100000. Try to sort this file using standard Linux command. Try to do the same with Java application. What is time of sorting with Java and with Linux commands? What is the size of source file that should be sorted? \ 

Try to run this script asynchronously (read about nohup). Try to look into a file in runtime while numbers generation (read about tail). Try to kill this process in the middle of numbers generation (read about kill).  

>**Just to think**...*What will you do if source file size will be 20GB? Is your Java application ready for this?*
