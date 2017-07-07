package ru.itis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private Integer shotXPlayer1;
    private Integer shotYPlayer1;
    private Integer shotXPlayer2;
    private Integer shotYPlayer2;

    private String statusPlayer1;
    private String statusPlayer2;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to SeaBattleServer, Boyets!";
    }

    // игрок player делает выстрел в позицию X и Y
    @GetMapping("battle/shot")
    public void shot(@RequestParam("shotX") int X,
                       @RequestParam("shotY") int Y,
                       @RequestParam("player") int player) {
        System.out.println("battle/shot " + player);
        if (player == 2) {
            shotXPlayer1 = X;
            shotYPlayer1 = Y;
        } else {
            shotXPlayer2 = X;
            shotYPlayer2 = Y;
        }
    }

    // игрок player получает информацию о том, куда в него выстрелили
    @GetMapping("battle/shot/info")
    public String getShotInfo(@RequestParam("player") int player) {
        System.out.println("battle/shot/info " + player);
        while (true) {
            if (player == 1) {
                if (shotXPlayer1 != null && shotYPlayer1 != null) {
                    int x = shotXPlayer1;
                    int y = shotYPlayer1;
                    shotXPlayer1 = null;
                    shotYPlayer1 = null;
                    return x + " " + y;
                }
            } else {
                if (shotXPlayer2 != null && shotYPlayer2 != null) {
                    int x = shotXPlayer2;
                    int y = shotYPlayer2;
                    shotXPlayer2 = null;
                    shotYPlayer2 = null;
                    return x + " " + y;
                }
            }
        }
    }

    // игрок player получает информацию о статусе своего выстрела
    @GetMapping("/battle/shot/status/info")
    public String getStatus(@RequestParam("player") int player) {
        System.out.println("battle/shot/status/info " + player);
        while (true) {
            if (player == 1) {
                if (statusPlayer1 != null) {
                    String temp = statusPlayer1;
                    statusPlayer1 = null;
                    return temp;
                }
            } else {
                if (statusPlayer2 != null) {
                    String temp = statusPlayer2;
                    statusPlayer2 = null;
                    return temp;
                }
            }
        }
    }

    // игрок player сообщает информацию о статусе выстрела противника в него
    @GetMapping("/battle/shot/status")
    public void sendStatus(@RequestParam("status") String status,
                             @RequestParam("player") int player) {
        System.out.println("battle/shot/status  " + player + " " + status);
        if (player == 1) {
            statusPlayer2 = status;
        } else {
            statusPlayer1 = status;
        }
    }
}
