//package model;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//
//public class RabbitTest {
//
//    private Rabbit r1;
//    private Habit h1;
//    private Habit h2;
//    private Habit h3;
//    private Habit h4;
//    private Habit h11;
//    private Habit h22;
//    private Habit h33;
//    private Habit h44;
//
//
//    @BeforeEach
//    public void runBefore() {
//        r1 = new Rabbit("Kirby");
//        h1 = new Habit("Gym", "go to gym", 1, "Lifestyle");
//        h2 = new Habit("Email", "reply to emails", 3, "Social");
//        h3 = new Habit("Vegetable", "eat vegetables", 3, "Diet");
//        h4 = new Habit("Read", "read book", 2, "Hobby");
//        h11 = new Habit("Bike", "ride a bike", 4, "Lifestyle");
//        h22 = new Habit("Slack", "reply to slack", 3, "Social");
//        h33 = new Habit("Drink water", "drink water", 8, "Diet");
//        h44 = new Habit("Crochet", "do crochet", 4, "Hobby");
//        r1.addHabit(h1);
//        r1.addHabit(h2);
//        r1.addHabit(h3);
//        r1.addHabit(h4);
//        r1.addHabit(h11);
//        r1.addHabit(h22);
//        r1.addHabit(h33);
//        r1.addHabit(h44);
//    }
//
//    @Test
//    public void testRabbit() {
//        assertEquals("Kirby", r1.getName());
//        assertFalse(r1.isFit());
//        assertFalse(r1.isDietGood());
//        assertFalse(r1.isEntertained());
//        assertFalse(r1.isNotLonely());
//        assertFalse(r1.isHappy());
//        assertEquals(28, r1.getMaxHappiness());
//        assertEquals(0, r1.getHappiness());
//        r1.updateProgress(h1);
//        r1.updateProgress(h2);
//        r1.updateProgress(h2);
//        r1.updateProgress(h2);
//        r1.updateProgress(h3);
//        r1.updateProgress(h3);
//        r1.updateProgress(h3);
//        r1.updateProgress(h4);
//        r1.updateProgress(h4);
//        assertFalse(r1.isHappy());
//        r1.updateProgress(h11);
//        r1.updateProgress(h11);
//        r1.updateProgress(h22);
//        r1.updateProgress(h22);
//        r1.updateProgress(h22);
//        r1.updateProgress(h33);
//        r1.updateProgress(h33);
//        r1.updateProgress(h33);
//        r1.updateProgress(h33);
//        r1.updateProgress(h33);
//        r1.updateProgress(h33);
//        r1.updateProgress(h33);
//        r1.updateProgress(h33);
//        r1.updateProgress(h44);
//        r1.updateProgress(h44);
//        assertEquals(24, r1.getHappiness());
//        assertEquals(28, r1.getMaxHappiness());
//        assertTrue(r1.isHappy());
//    }
//
//    @Test
//    public void testIsFit() {
//        assertFalse(r1.isFit());
//        r1.updateProgress(h1);
//        r1.updateProgress(h11);
//        assertFalse(r1.isFit());
//        r1.updateProgress(h11);
//        r1.updateProgress(h11);
//        r1.updateProgress(h11);
//        r1.updateProgress(h11);
//        assertTrue(r1.isFit());
//    }
//
//    @Test
//    public void testIsSocialGood() {
//        assertFalse(r1.isNotLonely());
//        r1.updateProgress(h2);
//        r1.updateProgress(h2);
//        r1.updateProgress(h2);
//        assertFalse(r1.isNotLonely());
//        r1.updateProgress(h22);
//        r1.updateProgress(h22);
//        r1.updateProgress(h22);
//        assertTrue(r1.isNotLonely());
//        assertFalse(r1.isHappy());
//    }
//
//    @Test
//    public void testIsDietGood() {
//        assertFalse(r1.isDietGood());
//        r1.updateProgress(h3);
//        r1.updateProgress(h3);
//        r1.updateProgress(h3);
//        r1.updateProgress(h33);
//        r1.updateProgress(h33);
//        r1.updateProgress(h33);
//        assertFalse(r1.isDietGood());
//        r1.updateProgress(h33);
//        r1.updateProgress(h33);
//        r1.updateProgress(h33);
//        r1.updateProgress(h33);
//        assertFalse(r1.isDietGood());
//        r1.updateProgress(h33);
//        assertTrue(r1.isDietGood());
//        r1.updateProgress(h33);
//        r1.updateProgress(h33);
//        assertTrue(r1.isDietGood());
//    }
//
//    @Test
//    public void testIsEntertained() {
//        assertFalse(r1.isEntertained());
//        r1.updateProgress(h4);
//        r1.updateProgress(h4);
//        r1.updateProgress(h4);
//        assertFalse(r1.isEntertained());
//        r1.updateProgress(h44);
//        r1.updateProgress(h44);
//        r1.updateProgress(h44);
//        r1.updateProgress(h44);
//        assertTrue(r1.isEntertained());
//        assertFalse(r1.isHappy());
//    }
//}
