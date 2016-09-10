package net.styppen;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

import static spark.Spark.*;

/**
 * Created by styppen on 09/09/16.
 */
public class Main
{
   private static List<String> firstAdjectives = Arrays.asList("artless","bawdy","beslubbering","bootless","churlish","cockered",
                                                               "clouted","craven","currish","dankish","dissembling","droning","errant",
                                                               "fawning","fobbing","froward","frothy","gleeking","goatish","gorbellied",
                                                               "impertinent","infectious","jarring","loggerheaded","lumpish","mammering",
                                                               "mangled","mewling","paunchy","pribbling","puking","puny","qualling","rank",
                                                               "reeky","roguish","ruttish","saucy","spleeny","spongy","surly","tottering",
                                                               "unmuzzled","vain","venomed","villainous","warped","wayward","weedy","yeasty");

   private static List<String> secondAdjectives = Arrays.asList("base-court","bat-fowling","beef-witted","beetle-headed","boil-brained","clapper-clawed",
                                                                "clay-brained","common-kissing","crook-pated","dismal-dreaming","dizzy-eyed","doghearted",
                                                                "dread-bolted","earth-vexing","elf-skinned","fat-kidneyed","fen-sucked","flap-mouthed",
                                                                "fly-bitten","folly-fallen","fool-born","full-gorged","guts-griping","half-faced","hasty-witted",
                                                                "hedge-born","hell-hated","idle-headed","ill-breeding","ill-nurtured","knotty-pated","milk-livered",
                                                                "motley-minded","onion-eyed","plume-plucked","pottle-deep","pox-marked","reeling-ripe","rough-hewn",
                                                                "rude-growing","rump-fed","shard-borne","sheep-biting","spur-galled","swag-bellied","tardy-gaited",
                                                                "tickle-brained","toad-spotted","unchin-snouted","weather-bitten");

   private static List<String> nouns = Arrays.asList("apple-john","baggage","barnacle","bladder","boar-pig","bugbear","bum-bailey","canker-blossom","strumpet",
                                                     "clack-dish","clotpole","coxcomb","codpiece","death-token","dewberry","flap-dragon","flax-wench","varlot","wagtail",
                                                     "flirt-gill","foot-licker","fustilarianƒ","giglet","gudgeon","haggard","harpy","hedge-pig","horn-beast","vassal",
                                                     "hugger-mugger","joithead","lewdster","lout","maggot-pie","malt-worm","mammet","measle","minnow","miscreant",
                                                     "moldwarp","mumble-news","nut-hook","pigeon-egg","pignut","puttock","pumpion","ratsbane","scut","skainsmate","whey-face"
   );

   public static void main(String[] args)
   {
      port(getHerokuAssignedPort());
      externalStaticFileLocation("public");
      post("/insult", ((request, response) -> {
         JSONObject obj = insultMe();
         return obj;
      }));
      init();
   }

   private static JSONObject insultMe()
   {
      JSONObject obj = new JSONObject();
      int firstAdjectiveIdx = (int)(Math.random()*firstAdjectives.size());
      int secondAdjectiveIdx = (int)(Math.random()*secondAdjectives.size());
      int noundIdx = (int)(Math.random()* nouns.size());
      obj.put("first", firstAdjectives.get(firstAdjectiveIdx));
      obj.put("second", secondAdjectives.get(secondAdjectiveIdx));
      obj.put("noun", nouns.get(noundIdx));
      return obj;
   }

   static int getHerokuAssignedPort() {
      ProcessBuilder processBuilder = new ProcessBuilder();
      if (processBuilder.environment().get("PORT") != null) {
         return Integer.parseInt(processBuilder.environment().get("PORT"));
      }
      return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
   }

}
