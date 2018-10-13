// File: PolymorphRefs.java
interface IDrawable {
  void draw();
}
//_______________________________________________________________________________
class Shape implements IDrawable {
  @Override public void draw() { System.out.println("Drawing a Shape."); }
}
//_______________________________________________________________________________
class Circle extends Shape {
  @Override public void draw() { System.out.println("Drawing a Circle."); }
}
//_______________________________________________________________________________
class Rectangle extends Shape {
  @Override public void draw() { System.out.println("Drawing a Rectangle."); }
}
//_______________________________________________________________________________
class Square extends Rectangle {
  @Override public void draw() { System.out.println("Drawing a Square."); }
}
//_______________________________________________________________________________
class Graph implements IDrawable {
  @Override public void draw() { System.out.println("Drawing a Graph."); }
}
//_______________________________________________________________________________
public class PolymorphRefs {
  public static void main(String[] args) {
    Shape[] shapes = {new Circle(), new Rectangle(), new Square()};       // (1)
    IDrawable[] drawables = {new Shape(), new Rectangle(), new Graph()};  // (2)

    System.out.println("Draw shapes:");
    for (Shape shape : shapes)                                            // (3)
      shape.draw();

    System.out.println("Draw drawables:");
    for (IDrawable drawable : drawables)                                  // (4)
      drawable.draw();
  }
}