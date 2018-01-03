/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jatorfx;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.sinclair.jator.model.Sea;
import org.sinclair.jator.model.SeaCreature;
import org.sinclair.jator.model.SeaPosition;

/**
 *
 * @author michael
 */
public class JaTorFX extends Application {

    static Random random;
    static Sea sea;
    static int x;
    static int y;
    static int fishSpawn;
    static int fishStarve;
    static int sharkSpawn;
    static int sharkStarve;
    static boolean allCreatures;
    static int cellsize;

    private static void Jator() {
        JaTorFX.random = new Random();
        JaTorFX.x = 160;
        JaTorFX.y = 90;
        JaTorFX.x = 320;
        JaTorFX.y = 180;
        JaTorFX.fishSpawn = 2;
        JaTorFX.fishStarve = 99;
        JaTorFX.sharkSpawn = 5;
        JaTorFX.sharkStarve = 3;
        JaTorFX.allCreatures = false;
        JaTorFX.cellsize = 4;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jator();
        generateSea();
        launch();
    }

    static void generateSea() {
        int allCells;
        allCells = JaTorFX.x * JaTorFX.y;
        int sharks;
        sharks = allCells / 10;
        int fishes;
        fishes = allCells / 4;

        JaTorFX.sea = new Sea(JaTorFX.x, JaTorFX.y, JaTorFX.random);

        boolean noCreature;
        SeaPosition position;
        SeaCreature creature;
        int posX;
        int posY;

        for (int s = 0; s < sharks; s++) {
            noCreature = true;
            while (noCreature) {
                posX = random.nextInt(JaTorFX.x);
                posY = random.nextInt(JaTorFX.y);
                position = new SeaPosition(posX, posY, JaTorFX.sea);
                creature = JaTorFX.sea.addCreature(position, "Shark", JaTorFX.sharkSpawn, 0, JaTorFX.sharkStarve);
                if (creature != null) {
                    noCreature = false;
                }
            }
        }

        for (int f = 0; f < fishes; f++) {
            noCreature = true;
            while (noCreature) {
                posX = random.nextInt(x);
                posY = random.nextInt(y);
                position = new SeaPosition(posX, posY, JaTorFX.sea);
                creature = JaTorFX.sea.addCreature(position, "Fish", JaTorFX.fishSpawn, 0, JaTorFX.fishStarve);
                if (creature != null) {
                    noCreature = false;
                }
            }
        }
    }

    @Override
    public void start(Stage jatorStage) {
        long X = JaTorFX.sea.getMaxX() * JaTorFX.cellsize;
        long Y = JaTorFX.sea.getMaxY() * JaTorFX.cellsize;
        jatorStage.setTitle("Ja-Tor");
        Group root;
        root = new Group();
        Scene scene;
        scene = new Scene(root, Color.BLUE);
        Canvas canvas = new Canvas(X, Y);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        jatorStage.setScene(scene);

        Timeline gameLoop = new Timeline();
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf;
        kf = new KeyFrame(
                //                Duration.seconds(0.084), // 12 FPS
                Duration.seconds(0.06), // ~16 FPS
                //                Duration.seconds(0.042), // 24 FPS
                //                Duration.seconds(0.021), // 48 FPS
                //                Duration.seconds(0.017), // 60 FPS
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                // Clear the canvas
                gc.clearRect(0, 0, X, Y);

                long startTime = System.nanoTime();
                Collection<SeaCreature> collectedCreatures = JaTorFX.sea.getCreatures();
                Iterator<SeaCreature> iterateCreatures = collectedCreatures.iterator();
                while (iterateCreatures.hasNext()) {
                    SeaCreature c = iterateCreatures.next();
//                            System.out.println(c);
                    if (c.isAlive()) {
                        gc.setFill(c.getColor());
                        gc.fillRect(c.getPosition().getX() * JaTorFX.cellsize, c.getPosition().getY() * JaTorFX.cellsize, JaTorFX.cellsize, JaTorFX.cellsize);
                    }
                }
                double displayTime = (System.nanoTime() - startTime) / 1000000000.0;
                startTime = System.nanoTime();
                JaTorFX.sea.takeTurns();
                double turnTime = (System.nanoTime() - startTime) / 1000000000.0;
                System.out.println(String.format("Display Time: %2.4f Turn Time: %2.4f %s", displayTime, turnTime, JaTorFX.sea));
            }
        });

        gameLoop.getKeyFrames().add(kf);
        gameLoop.play();

        jatorStage.show();

    }
}
