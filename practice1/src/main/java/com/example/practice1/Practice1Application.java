package com.example.practice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Practice1Application {

	public static void main(String[] args) {
    SpringApplication.run(Practice1Application.class, args);

    Shape shape = new Shape(2, 3);
    Rectangle rectangle = new Rectangle(4, 6);
    Circle circle = new Circle(10);

    System.out.println("Shape: width=" + shape.getWidth()
            + ", height=" + shape.getHeight());

    System.out.println("Rectangle: width=" + rectangle.getWidth()
            + ", height=" + rectangle.getHeight()
            + ", area=" + rectangle.getArea()
            + ", perimeter=" + rectangle.getPerimeter());

    System.out.println("Circle: diameter=" + circle.getWidth()
            + ", area=" + circle.getArea()
            + ", circumference=" + circle.getCircumference());
}

}
