package Modules;

import GameState.GameStateManager;
import Main.Game;

public class ExecuteModule {
    public static void execute(Commander commander, String[] args, String command, GameStateManager gsm){
        Game.sys(command);
        for (String s: args) {
            Game.sys(s);
        }
        if(args[0].equals("gamestate")){
            if(args[1].equals("set")){
                gsm.loadState(GameStateManager.toInt(args[2]));
            }
        } else if(args[0].equals("craft")){
            if(args[1].equals(null)){

            }
        }
    }
}
