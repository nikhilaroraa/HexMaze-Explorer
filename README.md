# HexMaze Explorer 
HexMazeExplorer is an engaging Java game that challenges players to navigate a pyramid-shaped maze, find treasure chambers, and adhere to specific rules while exploring. The game consists of two key classes: PathFinder and Map, which collectively create a strategic and visually appealing gaming experience.

The PathFinder class serves as the core logic for navigating the maze. It utilizes a double-linked stack to systematically explore chambers while following constraints such as marking and popping chambers, tracking discovered treasures, and selecting the best chamber to move towards. The class encapsulates the game's rule-based path-finding algorithm, ensuring an intriguing adventure for players.

The Map class complements the gameplay by creating a graphical representation of the hexagon-tile based map. Extending JFrame, this class generates a window displaying hexagonal tiles, each representing a chamber within the pyramid maze. The map is constructed from an input file specifying the number of rows, columns, and optional hexagon size, with each chamber characterized by specific characters. The Map class categorizes hexagons into types like SEALED, ENTRANCE, TREASURE, TREASURE2, LIGHTED, DARK, and DIM, enhancing the visual appeal of the game.

Together, these classes form the backbone of HexMazeExplorer, offering players a unique and strategic adventure. The game challenges intellect through maze navigation, while the graphical representation enhances the overall gaming experience. The provided Java code encapsulates the game's logic, making it an interactive and visually engaging challenge for players.
