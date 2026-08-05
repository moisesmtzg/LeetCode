import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.*;

public class SnakeSwingGame extends JFrame {

    private SnakeGame game;
    private JTextArea textArea;

    public SnakeSwingGame() {
        game = new SnakeGame(15, 30);

        // Configuración de la Ventana
        setTitle("Snake Game (Haz clic aquí y usa W, A, S, D)");
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Área de texto para mostrar la matriz
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.BOLD, 18));
        textArea.setEditable(false);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.GREEN);

        // Evitamos que el JTextArea robe el foco del teclado
        textArea.setFocusable(false);
        add(textArea);

        // --- SOLUCIÓN DE ENFOQUE (FOCUS) ---
        setFocusable(true);
        requestFocus();

        // Escuchador de teclado en el JFrame
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char key = Character.toLowerCase(e.getKeyChar());
                // Soporte para teclas W, A, S, D y Flechas del teclado
                if (key == 'w' || e.getKeyCode() == KeyEvent.VK_UP) game.setDirection('w');
                if (key == 's' || e.getKeyCode() == KeyEvent.VK_DOWN) game.setDirection('s');
                if (key == 'a' || e.getKeyCode() == KeyEvent.VK_LEFT) game.setDirection('a');
                if (key == 'd' || e.getKeyCode() == KeyEvent.VK_RIGHT) game.setDirection('d');
            }
        });

        // Bucle del juego
        Timer timer = new Timer(250, e -> {
            if (game.step()) {
                textArea.setText(gridToStr(game.getGrid()));
            } else {
                textArea.setText(gridToStr(game.getGrid()) + "\n      ¡GAME OVER!");
                ((Timer) e.getSource()).stop();
            }
        });

        timer.start();
    }

    public static String gridToStr(char[][] grid) {
        StringBuilder sb = new StringBuilder();
        for (char[] row : grid) {
            for (char cell : row) {
                sb.append(cell).append(' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SnakeSwingGame frame = new SnakeSwingGame();
            frame.setVisible(true);
            frame.requestFocusInWindow(); // Forzar foco tras hacer visible la ventana
        });
    }

    // --- LÓGICA DEL JUEGO ---
    static class Point {
        int row, col;
        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point p = (Point) o;
            return row == p.row && col == p.col;
        }
    }

    static class SnakeGame {
        private int height, width;
        private LinkedList<Point> snake;
        private char dir;

        private static final Map<Character, List<Character>> ALLOWED_DIRS = Map.of(
                'w', List.of('a', 'd'),
                'a', List.of('w', 's'),
                's', List.of('a', 'd'),
                'd', List.of('w', 's')
        );

        public SnakeGame(int height, int width) {
            this.height = height;
            this.width = width;
            this.snake = new LinkedList<>();

            int headRow = height / 2;
            int headCol = width / 2;

            for (int i = 0; i < 3; i++) {
                snake.add(new Point(headRow, headCol - i));
            }
            this.dir = 'd';
        }

        public char[][] getGrid() {
            char[][] grid = new char[height][width];
            for (int r = 0; r < height; r++) {
                for (int c = 0; c < width; c++) {
                    Point current = new Point(r, c);
                    grid[r][c] = snake.contains(current) ? 'S' : '.';
                }
            }
            return grid;
        }

        public void setDirection(char keyPress) {
            if (ALLOWED_DIRS.containsKey(dir) && ALLOWED_DIRS.get(dir).contains(keyPress)) {
                this.dir = keyPress;
            }
        }

        public boolean step() {
            int drow = (dir == 'a' || dir == 'd') ? 0 : (dir == 'w' ? -1 : 1);
            int dcol = (dir == 'w' || dir == 's') ? 0 : (dir == 'a' ? -1 : 1);

            Point head = snake.getFirst();
            Point newHead = new Point(head.row + drow, head.col + dcol);

            if (newHead.row < 0 || newHead.row >= height || newHead.col < 0 || newHead.col >= width) {
                return false;
            }

            snake.removeLast();
            snake.addFirst(newHead);
            return true;
        }
    }
}