import javax.vecmath.Vector2d;
import java.util.List;
import java.util.Random;

public class ObstacleInitializer {

    private final List<Obstacle> obstacles;

    public ObstacleInitializer(List<Obstacle> obstacles) {
        this.obstacles = obstacles;
        generateObstacles();
    }

    private void generateObstacles() {

/*        Obstacle obstacle = new Obstacle(new Vector2d(120,0), new Vector2d(120,71));
        this.obstacles.add(obstacle);
        Obstacle obstacle1 = new Obstacle(new Vector2d(120,69), new Vector2d(120,141));
        this.obstacles.add(obstacle1);
        Obstacle obstacle2 = new Obstacle(new Vector2d(120,139), new Vector2d(120,211));
        this.obstacles.add(obstacle2);
        Obstacle obstacle3 = new Obstacle(new Vector2d(120,209), new Vector2d(120,281));
        this.obstacles.add(obstacle3);
        Obstacle obstacle4 = new Obstacle(new Vector2d(120,279), new Vector2d(120,351));
        this.obstacles.add(obstacle4);
        Obstacle obstacle5 = new Obstacle(new Vector2d(120,349), new Vector2d(120,421));
        this.obstacles.add(obstacle5);
        Obstacle obstacle6 = new Obstacle(new Vector2d(120,419), new Vector2d(120,491));
        this.obstacles.add(obstacle6);
        Obstacle obstacle7 = new Obstacle(new Vector2d(120,489), new Vector2d(120,561));
        this.obstacles.add(obstacle7);
        Obstacle obstacle8 = new Obstacle(new Vector2d(120,559), new Vector2d(120,631));
        this.obstacles.add(obstacle8);
        Obstacle obstacle9 = new Obstacle(new Vector2d(120,629), new Vector2d(120,701));
        this.obstacles.add(obstacle9);


        Obstacle obstacle20 = new Obstacle(new Vector2d(1320,0), new Vector2d(1320,71));
        this.obstacles.add(obstacle20);
        Obstacle obstacle21 = new Obstacle(new Vector2d(1320,69), new Vector2d(1320,141));
        this.obstacles.add(obstacle21);
        Obstacle obstacle22 = new Obstacle(new Vector2d(1320,139), new Vector2d(1320,211));
        this.obstacles.add(obstacle22);
        Obstacle obstacle23 = new Obstacle(new Vector2d(1320,209), new Vector2d(1320,281));
        this.obstacles.add(obstacle23);
        Obstacle obstacle24 = new Obstacle(new Vector2d(1320,279), new Vector2d(1320,351));
        this.obstacles.add(obstacle24);
        Obstacle obstacle25 = new Obstacle(new Vector2d(1320,349), new Vector2d(1320,421));
        this.obstacles.add(obstacle25);
        Obstacle obstacle26 = new Obstacle(new Vector2d(1320,419), new Vector2d(1320,491));
        this.obstacles.add(obstacle26);
        Obstacle obstacle27 = new Obstacle(new Vector2d(1320,489), new Vector2d(1320,561));
        this.obstacles.add(obstacle27);
        Obstacle obstacle28 = new Obstacle(new Vector2d(1320,559), new Vector2d(1320,631));
        this.obstacles.add(obstacle28);
        Obstacle obstacle29 = new Obstacle(new Vector2d(1320,629), new Vector2d(1320,701));
        this.obstacles.add(obstacle29);




        Obstacle obstacle10 = new Obstacle(new Vector2d(119,700), new Vector2d(241,700));
        this.obstacles.add(obstacle10);
        Obstacle obstacle11 = new Obstacle(new Vector2d(239,700), new Vector2d(361,700));
        this.obstacles.add(obstacle11);
        Obstacle obstacle12 = new Obstacle(new Vector2d(359,700), new Vector2d(481,700));
        this.obstacles.add(obstacle12);
        Obstacle obstacle13 = new Obstacle(new Vector2d(479,700), new Vector2d(601,700));
        this.obstacles.add(obstacle13);
        Obstacle obstacle14 = new Obstacle(new Vector2d(599,700), new Vector2d(721,700));
        this.obstacles.add(obstacle14);
        Obstacle obstacle15 = new Obstacle(new Vector2d(719,700), new Vector2d(841,700));
        this.obstacles.add(obstacle15);
        Obstacle obstacle16 = new Obstacle(new Vector2d(839,700), new Vector2d(961,700));
        this.obstacles.add(obstacle16);
        Obstacle obstacle17 = new Obstacle(new Vector2d(959,700), new Vector2d(1081,700));
        this.obstacles.add(obstacle17);
        Obstacle obstacle18 = new Obstacle(new Vector2d(1079,700), new Vector2d(1201,700));
        this.obstacles.add(obstacle18);
        Obstacle obstacle19 = new Obstacle(new Vector2d(1199,700), new Vector2d(1321,700));
        this.obstacles.add(obstacle19);*/

/*        for (int i = 0 ; i < 10 ; i++) {
            this.obstacles.add(new Obstacle(new Vector2d(new Random().nextInt(1440), new Random().nextInt(770)), new Vector2d(new Random().nextInt(1440),new Random().nextInt(770))));
        }*/
        //this.obstacles.add(new Obstacle(new Vector2d(200,150), new Vector2d(300,300)));
    }

    public List<Obstacle> getObstacles() {
        return this.obstacles;
    }

}
