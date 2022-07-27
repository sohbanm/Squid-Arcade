# Squid Arcade
Team  Name: Excited Explosive Compsci Students

Members of Team:
- Jason Yang(yangjas4@my.yorku.ca) Section O, Lab 02
- Sohban Elahi Malik(Sohbanm1@my.yorku.ca) Section P, Lab 01
- Aman Singh Sahni(aman1703@my.yorku.ca) Section P, Lab 01
- Angad Singh Rekhi(angarsr03@gmail.com) section P Lab 01

Project Name: Squid Arcade

# Description: 
For our project, we’ve decided to create an app with a series of mini-games inspired by the popular Netflix series “Squid Game”. The app will include 3 different games: Red Light Green Light, Marbles, Dalgona Cookies, and 2 side widgets: a weather widget and a basic 4 function calculator. 


In the game **Red Light Green Light**, players must reach the finish line within a set time limit without getting eliminated. To do this, players are given a button which when held will move the player forward. When the button is released, the player stops moving. While the player is making their way to the finish line, the game will constantly prompt either green light or red light in random intervals. When the prompt is green light, the player may move forward freely however if the prompt flashes red light and the player is still holding down the button, the player is eliminated. Alternatively, if the player does not move forward far enough to reach the finish line by the time limit, they are also eliminated. This game will have 3 difficulties: easy, medium and hard which will change the amount of time given to the player to complete the game. The game can either be played in single player or 2 player mode on the same device. In 2 player mode, the first player to pass the finish line causes the other player to be eliminated. Alternatively if one player is eliminated, the other player must pass the finish line in order to win. If both players are unable to pass the finish line, the game is a draw.


In the game **Marbles**, players must take all of the opponents marbles in order to win the game. At the beginning of the game, one player is assigned the first picker, and the other the first guesser. Both players begin with 10 marbles and alternate being the guesser and the picker in subsequent turns. At the beginning of each turn, the picker is prompted to gamble any number of marbles they have left in their hand greater (they must gamble something though or at least 1), and the guesser must guess whether the picker has gambled an odd or even number of marbles. After both players have picked, if the guesser was correct, they win all the marbles the picker gambled. If the guesser is wrong, they must give up the number of marbles the picker gambled. This keeps going until a player loses by running out of marbles to gamble. This game can be played either single player against the computer or against another player on the same device.



In the game **Dalgona Cookies**, the player picks between 5 difficulties: beginner/triangle, easy/square, medium/circle, hard/star, and insane/umbrella. The goal of the game is to cut out the cookie in a given time limit.  To do this the player is given a button and a bar. The bar will have a segment that will move from left to right of the bar periodically. When the player holds the button, they are able to slowly fill the bar until it reaches the maximum level in the bar. If the player releases the button, the level in the bar will decrease slowly until it reaches the minimum level in the bar. In order to make progress on the cookie, the player must keep the bar filled to a level that meets inside the segment while the segment periodically shifts positions on the bar and the cookie will only progress while the player’s level is in the bar. If the player’s bar level is not in the segment for more than 2 seconds, the cookie will snap and they will lose. The higher the difficulty level, the smaller the segment in the bar will be. 


# Functional Requirements

**Home Screen:**
- Users will see three buttons to select which game they want to play when the app is opened

**Red Light Green Light:**
- Before starting the game user can select one of 2 buttons single player or multiplayer
- There are 1 of 3 buttons for difficulty of the game, allocating a different amount of time to win in
- Text indicating the light that can be green or red and will be alternating for random intervals
- In singleplayer, there is one button used to move the player forward
- In multiplayer there are 2 buttons, one to move each player
- User will lose the game if they still have the move button pressed when the light is red
- A timer will appear counting down towards 0

**Marbles:**
- 2 gameplay options are available for players: singleplayer and multiplayer
- In singleplayer, the cpu opponent and the player are 
- On each respective players turn, user will be prompted in a textbox to enter a number of their marbles to gamble greater than 0
- Opposing player must will select odd or even button to guess the other players gamble
- Each user will see the amount of marbles they posses in a label ui element
- Player alternates roles between turns
- If guesser is correct, they will steal the marbles gambler, gambled. Otherwise the gambler takes the gamble amount of marbles from the guesser
- When a player possess less than 1 marble the game ends and they lose

**Dalgona Cookies:** 
- User will pick one of 5 optical ns for difficulties of shapes to be cutting
- There will be a bar with a segment inside that switches between several fixed positions randomly
- Segment size is made smaller for harder difficulties
- Player has a button to interact with, holding the button fills up the bar at a fixed rate and letting go of the buttons decreases the bar at a fixed rate
- Matching the level of the bar to the segment position creates progress on the cookie
- Not being in the segment for more than 2 seconds causes the player to lose the game 
- When the cookie progress is 100%, the player wins.
- Graphic indicating the cookie progress
