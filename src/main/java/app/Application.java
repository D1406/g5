package app;

import io.github.humbleui.jwm.*;
import java.util.function.Consumer;

public class Application implements Consumer<Event> {
    private final Window window;
    public Application() {
        // создаём окно
        window = App.makeWindow();
        // задаём обработчиком событий текущий объект
        window.setEventListener(this);
        // делаем окно видимым
        window.setVisible(true);
    }
    @Override
    public void accept(Event e) {
        if (e instanceof EventWindowClose) {
            // завершаем работу приложения
            App.terminate();
        }else if (e instanceof EventWindowCloseRequest) {
            window.close();
        }
    }
}
