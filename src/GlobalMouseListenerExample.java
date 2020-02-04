import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class GlobalMouseListenerExample implements NativeMouseInputListener {
    public void nativeMouseClicked(NativeMouseEvent e) {
        System.out.println("Mouse Clicked: " + e.getClickCount());
        try {
            FileInputStream fileInputStream = new FileInputStream("song.mp3");
            Player player = new Player(fileInputStream);
            player.play();
        } catch (FileNotFoundException er) {
            // TODO Auto-generated catch block
            er.printStackTrace();
        } catch (JavaLayerException er) {
            // TODO Auto-generated catch block
            er.printStackTrace();
        }
    }

    public void nativeMousePressed(NativeMouseEvent e) {
        //System.out.println("Mouse Pressed: " + e.getButton());
    }

    public void nativeMouseReleased(NativeMouseEvent e) {
        //System.out.println("Mouse Released: " + e.getButton());
    }

    public void nativeMouseMoved(NativeMouseEvent e) {
        //System.out.println("Mouse Moved: " + e.getX() + ", " + e.getY());
    }

    public void nativeMouseDragged(NativeMouseEvent e) {
        //System.out.println("Mouse Dragged: " + e.getX() + ", " + e.getY());
    }

    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        // Construct the example object.
        GlobalMouseListenerExample example = new GlobalMouseListenerExample();

        // Add the appropriate listeners.
        GlobalScreen.addNativeMouseListener(example);
        GlobalScreen.addNativeMouseMotionListener(example);
    }
}