public class Qtest{
    public static void main(String[] args){
        int[][] maze = {{1,0,1,1,1,1},{1,0,1,0,1,0},{1,0,1,0,1,1},{1,1,1,0,1,1}};
        BFS(0, 0, maze);
    }
    public static void BFS(int row, int col, int[][] maze){
        int[][] dir = {{1,0},{-1,0}, {0,1},{0,-1}};
        // Pixel pixel = canvas.pixels[row][col];
        // Color ink = pixel.getBackground();
        // pixel.setBackground(pencil.getColor());
        // pixel.setDefault(pixel.getBackground());
        Queue queue = new Queue(1000);
        queue.enqueue(row, col);
        while(!queue.isEmpty()){
            // Pixel 
            Pair pair = queue.dequeue();
            int fr = pair.row, fc = pair.col;
            for(int i = 0; i < 4; i++){
                int rr = fr + dir[i][0], cc = fc + dir[i][1];
                if(rr < 0 || rr >= 4 || cc < 0 || cc >= 6) continue;
                if(maze[rr][cc] == 1){
                    queue.enqueue(rr, cc);
                    maze[rr][cc] = maze[fr][fc] + 1;
                    System.out.println("("+rr+","+cc+")"+"="+maze[rr][cc]);
                }
            }
        }
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 6; j++){
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }
}


class Pair{
    public int row;
    public int col;
    public Pair(int r, int c){
        row = r;
        col = c;
    }
}

class Queue{

    private int rear;
    private int size;

    private Pair[] queue;


    public Queue(int i){
        // front = -1;
        rear = 0;
        size = i;
        queue = new Pair[size];
    }

    public boolean isEmpty(){
        return rear == 0;
    }

    public void enqueue(int row, int col){
        queue[rear++] = new Pair(row, col);
        System.out.println(rear);
    }

    public Pair dequeue(){
        Pair ans = queue[0];
        for(int i = 1; i < rear; i++){
            queue[i-1] = queue[i]; 
        }
        rear--;
        System.out.println(rear);
        return ans;
    }
}
