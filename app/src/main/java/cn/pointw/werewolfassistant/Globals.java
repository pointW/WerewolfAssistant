package cn.pointw.werewolfassistant;

/**
 * Created by outen on 16/7/23.
 */
public class Globals {
    public enum God{
        Hunter, Seer, Witch, Idiot, Elder, Cupid, Guard
    }

    public static String getGodString(God god){
        switch (god){
            case Hunter:
                return "猎人";
            case Seer:
                return "预言家";
            case Witch:
                return "女巫";
            case Idiot:
                return "白痴";
            case Elder:
                return "长老";
            case Cupid:
                return "丘比特";
            case Guard:
                return "守卫";
            default:
                return "???";
        }
    }
}
