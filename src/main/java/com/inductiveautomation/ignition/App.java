

package com.inductiveautomation.ignition;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.nio.file.Paths;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.engine.Language;
import com.teamdev.jxbrowser.navigation.LoadUrlParams;

import com.teamdev.jxbrowser.view.swing.BrowserView;
import net.miginfocom.swing.MigLayout;

import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;

public class App {

    JFrame frame = new JFrame();
    static final String INIT_URL = "http://www.inductiveautomation.com";
    String JXB_LICENSE = "<ADD LICENSE HERE>";
    App app;
    Engine engine; // jxbrowser engine

    public static void main(String[] args) {
        App app = new App();
        app.launch();
    }

    public void launch() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::shutdown));
        this.initFrame();
    }

    public void shutdown() {
        // test shutdown/lifecycle things here.
        if (engine != null && !engine.isClosed()) {
            engine.close();
        }
    }

    private Engine initEngine() {
        var chromiumDirectory = System.getProperty("user.home") + File.separator + ".jxbrowser";
        var debugPort = 9222;

        EngineOptions options = EngineOptions.newBuilder(HARDWARE_ACCELERATED)
            .remoteDebuggingPort(debugPort)
            .language(Language.ENGLISH_US)
            .licenseKey(JXB_LICENSE)
            .chromiumDir(Paths.get(chromiumDirectory))
            .build();

        return Engine.newInstance(options);
    }

    void initFrame() {
        engine = initEngine();
        Browser browser = engine.newBrowser();
        BrowserView view = BrowserView.newInstance(browser);

        // this will throw the error as well, layout type doesn't seem to matter
        // JPanel mainPanel = new JPanel(new MigLayout("fill"));
        // mainPanel.add(view, "push, grow");

        // comment these out, and uncomment lines above to try alternative layout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(view, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1200, 780);
        frame.setContentPane(mainPanel);
        frame.addWindowListener(new AppWindowListener(engine));
        frame.setVisible(true);

        LoadUrlParams loadUrl = LoadUrlParams.newBuilder(INIT_URL).build();

        EventQueue.invokeLater(() -> {
            browser.navigation().loadUrl(loadUrl);
            browser.devTools().remoteDebuggingUrl().ifPresent(debugUrl ->
                System.out.printf("Remote debug url: %s\n", debugUrl)
            );
        });
    }

    static class AppWindowListener implements WindowListener {
        Engine engine;

        AppWindowListener(Engine engine) {
            this.engine = engine;
        }

        @Override
        public void windowOpened(WindowEvent e) {

        }

        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("WindowClosing event detected.");
            if (engine != null && !engine.isClosed()) {
                System.out.println("Engine is being closed!");
                engine.close();
            } else {
                System.out.println("Engine was null or closed.");
            }
        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {

        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowActivated(WindowEvent e) {

        }

        @Override
        public void windowDeactivated(WindowEvent e) {

        }
    }
}
