
import java.util.Random;
// Shared NumberBox class
class NumberBox {
int number;
boolean available = false;
synchronized void put(int n) {
number = n;
available = true;
System.out.println("Thread 1: Generated Number = " + n);
notifyAll();
}
synchronized int get() throws InterruptedException {
while (!available) {
wait();
}
return number;
}
}
// Number Generator Thread
class NumberGenerator extends Thread {
NumberBox box;
NumberGenerator(NumberBox box) {
this.box = box;
}
public void run() {
Random r = new Random();
int n = r.nextInt(10) + 1;
box.put(n);
}
}
// Square Thread
class SquareThread extends Thread {
NumberBox box;
SquareThread(NumberBox box) {
this.box = box;
}
public void run() {
try {
int n = box.get();
switch (n % 2) {
case 0:
System.out.println("Thread 2: Square of " + n + " = "

        (n * n));
        break;

case 1:
break;
}
} catch (InterruptedException e) {
System.out.println("Square Thread Interrupted");
}
}
}
// Cube Thread
class CubeThread extends Thread {
NumberBox box;
CubeThread(NumberBox box) {
this.box = box;
}
public void run() {
try {
int n = box.get();
switch (n % 2) {
case 0:
break;
case 1:
System.out.println("Thread 3: Cube of " + n + " = "

        (n * n * n));
        break;
        }
        } catch (InterruptedException e) {
        System.out.println("Cube Thread Interrupted");
        }
        }
    }

// Main class
public class MultiThreadNumber {
public static void main(String[] args) {
NumberBox box = new NumberBox();
NumberGenerator generator = new NumberGenerator(box);
SquareThread square = new SquareThread(box);
CubeThread cube = new CubeThread(box);
generator.start();
square.start();
cube.start();
}
}
