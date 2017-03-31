package vinhtv.android.javalib;

import java.util.Random;

public class JokesSupplier {

    private static Random random = new Random();
    private static final String[] JOKE_STORIES = {
            "What's a build master's favorite black metal band?\nGradle of Filth!",
            "How long does it take to master build tools?\nFrom the Gradle to the grave.",
            "Teacher: Could you please pay a little attention here?\nStudent: yes mam, I am paying as little attention as i can. !!",
            "Teacher: From where to where foreigner ruled us?\nStudent: I am not sure but I think from page 50 to 55...",
            "Patient: Oh doctor, I'm just so nervous. This is my first operation.\nDoctor: Don't worry. Mine too.",
            "A naked women robbed a bank. Nobody could remember her face.",
            "Why is women's soccer so rare?\nIt's quite hard to find enough women willing to wear the same outfit."
    };

    public String provide() {
        int index = random.nextInt(JOKE_STORIES.length);
        return JOKE_STORIES[index];
    }

}
