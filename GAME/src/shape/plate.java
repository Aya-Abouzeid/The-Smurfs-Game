package shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import states.State;
import states.Stored;

public class plate extends Shape implements shapeInt {
    private Polygon platePolygon;
    private Double[] vertices = { 0.0, 0.0, 20.0, 16.0, 50.0, 16.0, 70.0, 0.0 };
    private double[] xVertices = { vertices[0], vertices[2], vertices[4], vertices[6] };
    private double[] yVertices = { vertices[1], vertices[3], vertices[5], vertices[7] };

    public plate() {
        Color c = colors[randomize.nextInt(colors.length)];
        this.color = c;
        platePolygon = new Polygon();
        platePolygon.getPoints().addAll(vertices);
        platePolygon.setFill(color);
        this.state = Stored.getStoredInstance();
        this.height = 16.0;
    }

    @Override
    public void setSlope(double screenWidth, double screenheight) {
    	
        this.slope = state.setSlope(screenWidth, screenheight);
    }

    @Override
    public void increaseSlopedY() {
        this.setY(this.getY() + 1);
        this.setX(state.increaseSlopedY(this.getY(), this.slope));
    }

    @Override
    public void drawShape(GraphicsContext gc) {
        gc.setFill(this.color);
        gc.fillPolygon(xVertices, yVertices, 4);
    }

    @Override
    public Polygon getShape() {
        return this.platePolygon;
    }

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public double getY() {
        return this.y;
    }

    @Override
    public double centerX() {
        return this.x + 35;
    }

    @Override
    public double centerY() {
        return this.y + 8;
    }

    @Override
    public void move(GraphicsContext gc, double shapeSpeed) {
        this.state.move(this, gc, shapeSpeed);
    }

    @Override
    public void setX(double x) {
        this.vertices[0] = x-35;
        this.vertices[2] = x - 15.0;
        this.vertices[4] = x + 15.0;
        this.vertices[6] = x + 35.0;
        this.xVertices[0] = x-35;
        this.xVertices[1] = x - 15.0;
        this.xVertices[2] = x + 15.0;
        this.xVertices[3] = x + 35.0;
        platePolygon.getPoints().addAll(vertices);
        this.x = x;
    }

    @Override
    public State getState() {
        return this.state;
    }

    @Override
    public void setState(State s) {
        this.state = s;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public double getHeight() {
        return this.height;
    }

    @Override
    public void setY(double y) {
        this.vertices[1] = y-8;
        this.vertices[3] = y + 8.0;
        this.vertices[5] = y + 8.0;
        this.vertices[7] = y-8;
        this.yVertices[0] = y-8;
        this.yVertices[1] = y + 8.0;
        this.yVertices[2] = y + 8.0;
        this.yVertices[3] = y-8;
        platePolygon.getPoints().addAll(vertices);
        this.y = y;
    }

}
