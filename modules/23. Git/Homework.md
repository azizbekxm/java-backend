**GIT task**

*Part 1. Basic (40 points)*
1. Change your system, global and repository config (add some values). Inspect how it is override.
2. Add some aliases in your own opinion.
3. Make init commit.
4. Create develop branch. Checkout on it.
5. Create index.html empty file. Commit.
6. Create branch with any name. Checkout on it. Add some images folder with images inside it. Commit.
7. Change your index.html. Add some image src inside it. Commit.
8. Go back to develop branch.
9. Create branch with any name. Checkout on it. Add some styles folder with styles source inside it. Commit.
10. Change your index.html. Add some styles inside it. Commit.
11. Go to develop branch.
12. Merge two new branches into develop using git merge command.
13. Don’t delete two new branches!
14. Merge develop into master
15. Repeat 6-15 items once more, but now use git rebase command for merging. Please, create situation with conflicts. It is will be better for your understanding.
16. Try to inspect your repository with git log command. Use different options with this command (git log --help)
17. Push all your changes with all your branches to remote repository.

*Part 2. Advanced (60 points)*
1. Checkout to master branch. Commit README document with any words or sentences.
2. Checkout to develop branch. Create base file (java) and add content inside (class with any name and one method “public int add(int a, int b)” with add operation implementation). Commit it to develop branch.
3. Create otherOperation branch.
4. Add sub (subtraction) implementation (new public method like on previous step). Commit.
5. Add div(division) implementation. Commit.
6. Add mult (multiplication) implementation. Commit.
7. Add sqrt implementation. Step by step.
    a. add method with implementation to your java file.
    b. add changed file to staging zone.
    c. get your staged file back to working directory (think how)
    d. change sqrt method name to sqrtBad.
    e. add to staging zone
    f. commit
8. Reset all your repo (read about reset command and all possible options of resetting) to mult implementation commit (i.e remove last commit with sqrtBad method)
9. Add sqrt implementation. Commit.
10. Rebase it to develop branch. Squash it to 1 commit. Write good and clear message.
11. Checkout to develop. Create new branch advancedOperation.
12. Add implementation for add operation with 2 parameters. The first line of method “System out (“This is add method”)”. Commit.
13. Add implementation for add operation with 3 parameters. The first line of method “System out (“This is add method for 3 params”)”. The first line of method add with 2 parameters “System out (“This is add method for 2 params”)”. Commit.
14. Add implementation for add operation with 4 parameters. The first line of method “System out (“This is add method for 4 params”)”. Commit.
15. Checkout to your “grandparent commit”. Copy first line of add method for 2 params. Checkout back to the “tail” of your current branch and paste line to add method with 2 params. Commit.
16. Merge it with develop branch.
17. Merge develop with master.
18. Push your changes to remote repository with all refs (branches).

When you are done with it – get your reflog, attach it to the result mail and send it to your mentor. 

Part 3 (Optional) Advanced
1.1 Pulling commits from the middle of git history
1.1.1 Checkout to branch “task${number}-feature”.
1.1.2 Add these features to your calculator sequentially in different commits:
1.1.2.1 Add div(division) implementation.
1.1.2.2 Add mult (multiplication) implementation.
1.1.3 Now let’s imagine that customer wants changes div(division) in nearest patch. Try to pull these changes to the main branch of this task “task${number}” using git cherry-pick and git rebase commands.
1.2 Investigate changes in files in GIT repository by git blame command.
1.3 Max mark for this part – 40 points
1.4 Extra mile: 20 point

1.4.1 Git `hook`s
1.4.1.1 Specify template of commit message and provide it for developer.
1.4.1.2 Check that build of new version is successful before committing changes.
1.4.1.3 Before pushing change to remote repository – check that there are no uncommitted changes.
1.4.2 Copy task folder to brand new repository with saving git history 
