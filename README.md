# commandline-archetype-template

This generates a Maven archetype for a command-line tool using log4j and getopt.

Build and install locally with
```
mvn package install archetype:update-local-catalog
mvn archetype:crawl
```

Create a new command-line project by issuing
```
mvn archetype:generate -DarchetypeGroupId=nu.liss -DarchetypeArtifactId=commandline-project
```

and then answering the questions.

This had some scm (svn) support built in previously, but I had to remove that since I'm not using svn anymore and was too lazy to update it for git.
