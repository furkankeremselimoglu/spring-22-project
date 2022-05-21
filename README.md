# Facility Location Problem
Furkan Kerem Selimoğlu, S018065
Melike Akal, S020960

### Execution Data

The sums of the distances of the facilities to all points were calculated, and held in sumDistances array. Facilities will be opened until size of the openedFacilities equal to  P. Then, the minimum value in the sumDistances is found and added to openedFacilities and deleted from unassignedFacilities. Finally, determined and printed which points will go to which open facilities.

|  P  | Facility  | Point  | Execution Time (milliseconds) |
| :---: | :---: | :---: | :-----------------: |
| 1 | 3 | 5 | 2,845 milliseconds |
| 3 | 5 | 20 | 4,091 milliseconds |
| 15 | 25 | 100 | 29,179 milliseconds |
| 75 | 150 | 1000 | 7378,742 milliseconds |

### Example Output
#### Inputs: P = 3, Facility = 5, Point = 20
![Example Output Screenshot](https://user-images.githubusercontent.com/83104753/169661646-16b041b0-19fc-464f-9cbf-d7300dc62d28.png)
