Current Progress on the Final Project:

So far, the code relies on a SymbolGraph to represent String monster names as vertices. I've included a test file which I've been using to ensure that the code works roughly
as expected. I pulled this test file from the SymbolGraph-CE, and it works as expected. Currently, the code prints the shortest path to every destination from a single souce,
very similar to what is found in the SymbolGraph-CE. I believe this is a good stepping stone towards the goal, however the code currently gets user input via the commandline. 
Before going much further with this implementation, I think it is important to get the GUI functional, so that user interaction comes via the dropdown boxes. The GUI has been
set up with some very basic styling to mostly look the part, however the dropdowns are currently non-functional. The PfMonster class has a constructor, but nothing else. 

Going forward: 
In my opinion, the next steps should be to get the dropdowns in the GUI functional, incorporate the actual Monster-csv rather than the current test-csv, and to finish the 
SymbolGraph-paths implementation so that only the source, path, and destination are printed. After this, the gui should be updated so that it displays the path, rather than
the path being printed on the commandline. 
