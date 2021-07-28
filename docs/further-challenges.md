# Further challenges

Although this game is playable, still many features are missing.

## Prevent Hanny from crossing a piece of coral

Right now, whenever Hanny collides with a piece of coral, her speed is set to 0.
This does slow her down, but doen not prevent her from crossing the piece of 
coral.

To make that work, you should not only set the speed to 0, but also reset 
Hannies location to exactly next to the piece of coral. Since Hanny can only 
travel horizontally or vertically, you should first figure out her direction and
then set het x- or y-coordinate to the right value.

## Prevent Hanny from respawning in the coral field

Because Hanny will respawn at a random location, she could also respawn on a
piece of coral. Because her speed is always set to 0, whenever she collides with
coral, leaving such a location is cumbersome. Resolve this by limiting the
locations at which Hanny can respawn.
