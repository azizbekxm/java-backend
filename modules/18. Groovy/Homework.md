**Calculator on Groovy**

1. Implement Calculator Using Groovy programming language.  (100 points)

**Input Parameter**: String to be calculated. It contains numbers, operators and parentheses.
* Support operations +,- with two arguments (1+2) 
* Support +,- with unlimited arguments 
* Support *,/ (don’t forget about operations priority) 
* Support bracket operation (“(2+2)*3”) 
* Use GString  
* Use at least two Groovy specific operators (**|?.|&. etc..) 
* Use Groovy Operator Overloading 
* Use Groovy closures 

Business logic should be covered by unit tests on groovy with 100%. 
Extra mile (20 points): 
* Use Spock test framework 

Other comments: 
* Input data can be integer and without spaces (For example: “2+2*(5-7)”) 

Implementation details:  
1. Unzip - GroovyCalculator.zip (attached to the mail) 
2. Use Project GroovyCalculator (which based on maven) as a base project for this task  
3. Finally, your logic should be called from  
   com.epam.cdp.caclulator.GroovyCalculator.calculate() 

    To build project and run test please use “mvn clean install” if you have installed maven on your machine  

Otherwise :  call this goals from your IDE  


Useful links: 
http://groovy-lang.org/documentation.html 

http://spockframework.org/spock/docs/1.1-rc-2/index.html 
