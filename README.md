![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white) ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white) ![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)  
✍️ [Track Progress](https://github.com/a-batts/cypher-vii/projects/2)
# [Cypher VII](https://cypher-vii.devpost.com/): Project Submission  
![](src/main/resources/section-purpose.png)
Cypher VII is the College of William & Mary's seventh annual hackathon sponsored by corporations/groups such as Northrup Gunman, CGI, Major Hacking League, and so forth.
We're excited to announce that we have a project submission for the [Cypher VII](https://cypher-vii.devpost.com/) hackathon.
A text-based adventure story filled with mini-games that make the experience dynamic and different on each play through.

![](src/main/resources/section-about.png)
Ebert's Quest is a text-based adventure game that is set at William & Mary. You participate in various mini-games that make you
more intelligent, coordinated, charismatic, and more. Or maybe not? We'll see how you prove yourself...

Ebert wakes up suddenly at Griffin's place, only to find out it's 2022. Let's see where you can take Ebert as he navigates a campus that does not know he exists.

![](src/main/resources/section-structure.png)  

| Folder    	          | File            	 | Note/Purpose                      	                                                      |
|----------------------|-------------------|------------------------------------------------------------------------------------------|
| Enums     	          | SkillLevel 	      | Standardize SkillLevel of each attribute. `LOW`, `MEDIUM`, or `HIGH`. 	                  |
| Minigames\datingSim	 | 	DatingQuestion   | Record to standardize prompt and choices	                                                |
| Minigames\datingSim  | DatingSim         | Core mini-game. `.start()`                                                               |
| Minigames\trivia     | TriviaQuestion    | Class to standardize prompt and choices.                                                 |
| Minigames\trivia     | Trivia            | Core mini-game. `.start()`                                                               |
| Minigames            | FindNumbers       | Core mini-game. `.start()`                                                               |
| Minigames            | JPanelInput       | Creates GUI with input fields that are returned. Used for `FindNumbers` and `VibeCheck`. |
| Minigames            | Minigame          | Interface to standardize flow of each mini-game via `.start()`.                          |
| Minigames            | TypingTest        | Core mini-game. `.start()`                                                               |
| Minigames            | VibeCheck         | Core mini-game. `.start()`                                                               |
| Gametree             | GameTree          | Binary tree implementation for story progression.                                        |
| Gametree             | TreeNode          | Binary tree node for usage in the `GameTree` class.                                      |
| main                 | FileLoader        | Loads JSON files and returns them as JsonObjects or strings.                             |
| main                 | Player            | Class that manages all attributes of the player.                                         |
| main                 | Prompt            | Class that standardizes getting user input with a single question and a list of choices. |

![](src/main/resources/section-minigames.png) 
### Mini-games dictate the information revealed.
Just like in real life, your skills will help guide you. But you must prove yourself!
For each play-through of the game, you will be faced with 2 random mini-games (increases repeatability) to enhance your skill.
The better you do, the more information you'll get during the story.
### Five Mini-games
| Minigame         	 | Skill        	 |
|--------------------|----------------|
| Dating Simulator 	 | Charisma     	 |
| Find Numbers     	 | Observation  	 |
| Trivia           	 | Intelligence 	 |
| Typing Test      	 | Coordination 	 |
| Vibe Check       	 | Intuition    	 |


![](src/main/resources/section-author.png)
[Alex Batts](mailto:ajbatts@wm.edu) (Computer Science '25)  
[Angela Sullivan](mailto:arsullivan@wm.edu) (Computer Science '25)   
[Jason LaPierre](mailto:jalapierre@wm.edu)  (Biology '25)  
[Erica White](mailto:emwhite@wm.edu) (Business Analytics '25)
