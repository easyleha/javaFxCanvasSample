package com.akadatsky;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int BOARD_WIDTH = 500;
    private static final int BOARD_HEIGHT = 500;
    private static final int FPS = 60;

    private Board board;
    private boolean closed;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("SimpleGame");
        Canvas canvas = new Canvas();
        board = new Board(canvas.getGraphicsContext2D());
        canvas.setWidth(BOARD_WIDTH);
        canvas.setHeight(BOARD_HEIGHT);
        BorderPane group = new BorderPane(canvas);
        Scene scene = new Scene(group);
        scene.setOnKeyPressed(event -> board.keyPressed(event.getCode()));
        primaryStage.setScene(scene);
        primaryStage.show();
        new Thread(this::runMainGameLoopInThread).start();

        Logger.log("Game started");
    }

    @Override
    public void stop() {
        closed = true;
    }

    private void runMainGameLoopInThread() {
        while (!closed) {
            // run in UI thread
            Platform.runLater(this::drawFrame);
            try {
                int pauseBetweenFramesMillis = 1000 / FPS;
                Thread.sleep(pauseBetweenFramesMillis);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    private void drawFrame() {
        board.draw();
        board.renderNextFrame();
    }

}
