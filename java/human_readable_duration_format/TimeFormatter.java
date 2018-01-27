// https://www.codewars.com/kata/52742f58faf5485cae000b9a
// solution written for java8

import java.util.concurrent.TimeUnit;

public class TimeFormatter {

    public static String formatDuration(int seconds) {
        if(seconds == 0) return "now";
        StringBuilder sb = new StringBuilder();
        if(seconds >= TimeUnit.DAYS.toSeconds(365)){
            long y = seconds / TimeUnit.DAYS.toSeconds(365);
            seconds -= y*TimeUnit.DAYS.toSeconds(365);
            if(y > 1){
                sb.append(y).append(" years");
            } else {
                sb.append(y).append(" year");
            }
        }

        if(seconds >= TimeUnit.DAYS.toSeconds(1)){
            long d = seconds / TimeUnit.DAYS.toSeconds(1);
            seconds -= d*TimeUnit.DAYS.toSeconds(1);
            if(sb.length() > 0) sb.append(", ");
            if(d > 1){
                sb.append(d).append(" days");
            } else {
                sb.append(d).append(" day");
            }
        }

        if(seconds >= TimeUnit.HOURS.toSeconds(1)){
            long h = seconds / TimeUnit.HOURS.toSeconds(1);
            seconds -= h*TimeUnit.HOURS.toSeconds(1);
            if(sb.length() > 0) sb.append(", ");
            if(h > 1){
                sb.append(h).append(" hours");
            } else {
                sb.append(h).append(" hour");
            }
        }

        if(seconds >= TimeUnit.MINUTES.toSeconds(1)){
            long m = seconds / TimeUnit.MINUTES.toSeconds(1);
            seconds -= m*TimeUnit.MINUTES.toSeconds(1);
            if(sb.length() > 0) sb.append(", ");
            if(m > 1){
                sb.append(m).append(" minutes");
            } else {
                sb.append(m).append(" minute");
            }
        }
        if(seconds > 1){
          if(sb.length() > 0) sb.append(", ");
            sb.append(seconds).append(" seconds");
        } else if(seconds == 1){
          if(sb.length() > 0) sb.append(", ");
            sb.append(seconds).append(" second");
        }

        if(sb.length() > 0 && sb.toString().contains(", ")) {
            int ind = sb.toString().lastIndexOf(", ");
            return sb.replace(ind, ind + 2, " and ").toString();
        }

        return sb.toString();
    }
}
