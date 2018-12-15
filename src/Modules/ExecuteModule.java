package Modules;

import Enums.CommanderTypes;
import GameState.GameStateManager;
import Main.Game;

public class ExecuteModule {
    public static String execute(Commander commander, String[] args, String command, GameStateManager gsm){
        Game.sys(command);
        for (String s: args) {
            Game.sys(s);
        }
        if(args[0].equals("gamestate")){
            if(commander.type.equals(CommanderTypes.CLIENT) || commander.type.equals(CommanderTypes.SERVER)){
                if(args[1].equals("set")){
                    gsm.loadState(GameStateManager.toInt(args[2]));
                }
            } else {
                return "You don't have the permission to use this command";
            }
        }
        if(args[0].equals("craft")){
            if(commander.type.equals(CommanderTypes.PLAYER)){
                if(args[1].equals(null)){
                    
                }
            } else {
                return "You must be a player to use this command";
            }
        }
        return "";
    }
}
