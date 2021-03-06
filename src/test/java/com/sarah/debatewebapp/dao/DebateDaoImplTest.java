/*
 *  Copyright 2017 SarahBoka
 */
package com.sarah.debatewebapp.dao;

import com.sarah.debatewebapp.dto.Debate;
import com.sarah.debatewebapp.dto.Rebuttal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Sarah
 */
public class DebateDaoImplTest {
    
    private DebateDao testDao;
    ArrayList<Rebuttal> rebuttals = new ArrayList<>();
    Date dateStamp = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String date = sdf.format(dateStamp);
    List<Debate> testSearchDebateResults;
    
    public DebateDaoImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext factory = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        testDao = factory.getBean("debateJdbcDao", DebateDao.class);
        JdbcTemplate cleaner = factory.getBean("jdbcTemplateBean", JdbcTemplate.class);
        cleaner.execute("DELETE FROM rebuttals WHERE 1=1");
        cleaner.execute("DELETE FROM debates WHERE 1=1");
    }
    
    @After
    public void tearDown() {
    }
        
    Debate[] debatesForTesting = {
        new Debate(1, "Technology has allowed bloody hongis to participate in the global conversation of sweet mates.", "After the Tui is skived off, you add all the pearler quater-acre patches to the pavlova you've got yourself a meal.", "live", "debatinNotHatin", "sawadeeka", 6, 3, "music", date,  new ArrayList<>(), true),
        new Debate(2, "Elliot Smith is better than Bob Dylan.", "Mean while, in Shortland Street, Cardigan Bay and a Taniwha were up to no good", "live", "X2truDebatorX", "mdb8r", 6, 10, "music", date, new ArrayList<>(), true),
        new Debate(3, "Going vegan is substantially better for the environment", "The random force of his rooting was on par with Uncle Bully's wicked L&P.", "wash", "mdb8r", "snowOwl22", 4, 4, "ethics", date, new ArrayList<>(), true),
        new Debate(4, "Peter Singer is one of the greatest thinkers of our time.", "Put the jug on will you bro, all these fully sick tomato sauces can wait till later.", "conWon", "snowOwl22", "mdb8r", 5, 7, "philosophy", date, new ArrayList<>(), true),
        new Debate(5, "Chron is better than dabs.", "Sup bro! Where's the chips bro, this stoked seabed is as sweet as as a same same but different", "live", "mdb8r", "debatinNotHatin", 0, 0, "technology", date, new ArrayList<>(), false),
        new Debate(6, "Excessive advertisments are hurting the American mind.", "The first prize for skiving off goes to...", "live","cheesinForTheWeekend", "snowOwl22", 0, 0, "politics", date, new ArrayList<>(), false),
        new Debate(7, "Capitalism is actually pretty inefficient.", "Fred Dagg and his outrageously awesome Monopoly", "proWon", "sawadeeka", "snowOwl22", 11, 8, "politics", date, new ArrayList<>(), true),
    };
    
    Debate[] duplicateDebates = {
        new Debate(1, "Technology has allowed bloody hongis to participate in the global conversation of sweet mates.", "After the Tui is skived off, you add all the pearler quater-acre patches to the pavlova you've got yourself a meal.", "live", "debatinNotHatin", "sawadeeka", 6, 3, "music", date,  new ArrayList<>(), true),
        new Debate(2, "Elliot Smith is better than Bob Dylan.", "Mean while, in Shortland Street, Cardigan Bay and a Taniwha were up to no good", "live", "X2truDebatorX", "mdb8r", 6, 10, "music", date, new ArrayList<>(), true),
        new Debate(3, "Going vegan is substantially better for the environment", "The random force of his rooting was on par with Uncle Bully's wicked L&P.", "wash", "mdb8r", "snowOwl22", 4, 4, "ethics", date, new ArrayList<>(), true),
        new Debate(4, "Peter Singer is one of the greatest thinkers of our time.", "Put the jug on will you bro, all these fully sick tomato sauces can wait till later.", "conWon", "snowOwl22", "mdb8r", 5, 7, "philosophy", date, new ArrayList<>(), true),
        new Debate(5, "Chron is better than dabs.", "Sup bro! Where's the chips bro, this stoked seabed is as sweet as as a same same but different", "live", "mdb8r", "debatinNotHatin", 0, 0, "technology", date, new ArrayList<>(), false),
        new Debate(6, "Excessive advertisments are hurting the American mind.", "The first prize for skiving off goes to...", "live","cheesinForTheWeekend", "snowOwl22", 0, 0, "politics", date, new ArrayList<>(), false),
        new Debate(7, "Capitalism is actually pretty inefficient.", "Fred Dagg and his outrageously awesome Monopoly", "proWon", "sawadeeka", "snowOwl22", 11, 8, "politics", date, new ArrayList<>(), true),
    };
    
    Debate[] similarDebates = {
        new Debate(1, "zTechnology has allowed hongis to participate in the global conversation of sweet mates.", "After the Tui is skived off, you add all the pearler quater-acre patches to the pavlova you've got yourself a meal.", "live", "debatinNotHatin", "sawadeeka", 6, 3, "music", date,  new ArrayList<>(), true),
        new Debate(2, "zElliot Smith is better than Bob Dylan.", "Mean while, in Shortland Street, Cardigan Bay and a Taniwha were up to no good", "conWon", "X2truDebatorX", "mdb8r", 6, 10, "music", date, new ArrayList<>(), true),
        new Debate(3, "zGoing vegan is substantially better for the environment", "The random force of his rooting was on par with Uncle Bully's wicked L&P.", "wash", "sawadeeka", "snowOwl22", 4, 4, "ethics", date, new ArrayList<>(), true),
        new Debate(4, "zPeter Singer is one of the greatest thinkers of our time.", "Put the jug on will you bro, all these fully sick tomato sauces can wait till later", "conWon", "snowOwl22", "mdb8r", 4, 7, "philosophy", date, new ArrayList<>(), true),
        new Debate(5, "zChron is better than dabs.", "Sup bro! Where's the chips bro, this stoked seabed is as sweet as as a same same but different", "live", "mdb8r", "debatinNotHatin", 0, 0, "politics", date, new ArrayList<>(), false),
        new Debate(6, "zExcessive advertisments are hurting the American mind.", "The first prize for skiving off goes to...", "live","cheesinForTheWeekend", "snowOwl22", 0, 0, "politics", date, new ArrayList<>(), false),
        new Debate(7, "zCapitalism is actually pretty inefficient.", "Fred Dagg and his outrageously awesome Monopoly", "proWon", "sawadeeka", "snowOwl22", 11, 9, "politics", date, new ArrayList<>(), true),
    };
    
    Debate[] introDebatesForTesting = {
        new Debate(1, "Technology has allowed bloody hongis to participate in the global conversation of sweet mates.", "After the Tui is skived off, you add all the pearler quater-acre patches to the pavlova you've got yourself a meal.", "debatinNotHatin", "music", date, true),
        new Debate(2, "Elliot Smith is better than Bob Dylan.", "Mean while, in Shortland Street, Cardigan Bay and a Taniwha were up to no good","X2truDebatorX", "music", date, true),
        new Debate(3, "Going vegan is substantially better for the environment", "The random force of his rooting was on par with Uncle Bully's wicked L&P.","mdb8r", "ethics", date, true),
        new Debate(4, "Peter Singer is one of the greatest thinkers of our time.", "Put the jug on will you bro, all these fully sick tomato sauces can wait till later.", "snowOwl22", "philosophy", date, true),
        new Debate(5, "Chron is better than dabs.", "Sup bro! Where's the chips bro, this stoked seabed is as sweet as as a same same but different", "mdb8r", "technology", date, false),
        new Debate(6, "Excessive advertisments are hurting the American mind.", "The first prize for skiving off goes to...", "snowOwl22", "politics", date, false),
        new Debate(7, "Capitalism is actually pretty inefficient.", "Fred Dagg and his outrageously awesome Monopoly", "sawadeeka", "politics", date, true),
        new Debate(8, "New Zealand version with Queen Street and stuff", "The naff force of his playing rugby was on par with the Armed Offenders Squad's rough as guts stubbies.", "mdb8r", "cats", date, true),
        new Debate(9, "Every time I see those heaps good Grandpa's slippers", "The next Generation of hard case sad guys have already munted over at Pack n' Save.", "cheesinForTheWeekend", "history", date, false),
        new Debate(10, "Bro, cookie times are really beached as good with buzzy lengths of number 8 wire, aye.", "Put the jug on will you bro, all these mean as toasted sandwichs can wait till later.", "cheesinForTheWeekend", "cats", date, true),
        new Debate(11, "Rhys Darby was packing a sad when the stuffed cooking up.", "some uni student is just Manus Morissette in disguise, to find the true meaning of life, one must start pashing with the jersey, mate.", "debatinNotHatin", "history", date, true),
        new Debate(12, "Hairy Maclary from Donaldson's Dairy and his hard yakka weka.", " cookie times are really beached as good with buzzy lengths of number 8 wire, aye. You have no idea how rip-off our mint Edmonds Cook Books were aye.", "sawadeeka", "politics", date, true)
    };
    
    Debate[] duplicateIntroDebates = {
        new Debate(1, "Technology has allowed bloody hongis to participate in the global conversation of sweet mates.", "After the Tui is skived off, you add all the pearler quater-acre patches to the pavlova you've got yourself a meal. ", "debatinNotHatin", "music", date, true),
        new Debate(2, "Elliot Smith is better than Bob Dylan.", "Mean while, in Shortland Street, Cardigan Bay and a Taniwha were up to no good","X2truDebatorX", "music", date, true),
        new Debate(3, "Going vegan is substantially better for the environment", "The random force of his rooting was on par with Uncle Bully's wicked L&P.","mdb8r", "ethics", date, true),
        new Debate(4, "Peter Singer is one of the greatest thinkers of our time.", "Put the jug on will you bro, all these fully sick tomato sauces can wait till later.", "snowOwl22", "philosophy", date, true),
        new Debate(5, "Chron is better than dabs.", "Sup bro! Where's the chips bro, this stoked seabed is as sweet as as a same same but different", "mdb8r", "technology", date, false),
        new Debate(6, "Excessive advertisments are hurting the American mind.", "The first prize for skiving off goes to...", "snowOwl22", "politics", date, false),
        new Debate(7, "Capitalism is actually pretty inefficient.", "Fred Dagg and his outrageously awesome Monopoly", "sawadeeka", "politics", date, true),
        new Debate(8, "New Zealand version with Queen Street and stuff", "The naff force of his playing rugby was on par with the Armed Offenders Squad's rough as guts stubbies.", "mdb8r", "cats", date, true),
        new Debate(9, "Every time I see those heaps good Grandpa's slippers", "The next Generation of hard case sad guys have already munted over at Pack n' Save.", "cheesinForTheWeekend", "history", date, false),
        new Debate(10, "Bro, cookie times are really beached as good with buzzy lengths of number 8 wire, aye.", "Put the jug on will you bro, all these mean as toasted sandwichs can wait till later.", "cheesinForTheWeekend", "cats", date, true),
        new Debate(11, "Rhys Darby was packing a sad when the stuffed cooking up.", "some uni student is just Manus Morissette in disguise, to find the true meaning of life, one must start pashing with the jersey, mate.", "debatinNotHatin", "history", date, true),
        new Debate(12, "Hairy Maclary from Donaldson's Dairy and his hard yakka weka.", " cookie times are really beached as good with buzzy lengths of number 8 wire, aye. You have no idea how rip-off our mint Edmonds Cook Books were aye.", "sawadeeka", "politics", date, true)
    };
    
    Debate[] similarIntroDebates = {
        new Debate(1, "Technology hasn't allowed blood hongis to participate in the global convos of sweet mates.", "After the Tui is skived off, you add all the pearler quater-acre patches to the pavlova you've got yourself a meal. ", "debatinNotHatin", "music", date, true),
        new Debate(2, "Elliot Smith is better than Bob Dylan.", "Mean while, in Shortland Street, Cardigan Bay and a Taniwha were up to no good","X2truDebatorX", "music", date, true),
        new Debate(3, "Going vegan is substantially better for the environment", "The random force of his rooting was on par with Uncle Bully's wicked L&P.","mdb8r", "ethics", date, true),
        new Debate(4, "Peter Singer is one of the greatest thinkers of our time.", "Put the jug on will you bro, all these fully sick tomato sauces can wait till later.", "snowOwl22", "music", date, true),
        new Debate(5, "Chron is better than dabs.", "Sup bro! Where's the chips bro, this stoked seabed is as sweet as as a same same but different", "X2truDebatorX", "technology", date, false),
        new Debate(6, "Excessive advertisments are hurting the American mind.", "The first prize for skiving off goes to.", "snowOwl22", "politics", date, false),
        new Debate(7, "Crapitalism is actually pretty inefficient.", "Fred Dagg and his outrageously awesome Monopoly.", "sawadeeka", "philosophy", date, true),
        new Debate(8, "New Zealand version with Queen Street and stuff.", "The naff force of his playing rugby was on par with the Armed Offenders Squad's rough as guts stubbies.", "mdb8r", "cats", date, true),
        new Debate(9, "Every time I see those heaps good Grandpa's slippers", "The next Generation of hard case sad guys have already munted over at Pack n' Save.", "debatinNotHatin", "history", date, false),
        new Debate(10, "Bro, cookie times are really beached as good with buzzy lengths of number 8 wire, aye.", "Put the jug on will you bro, all these mean as toasted sandwichs can wait till later.", "cheesinForTheWeekend", "cats", date, true),
        new Debate(11, "Rhys Darby was packing a sad when the stuffed cooking up.", "some uni student is just Manus Morissette in disguise, to find the true meaning of life, one must start pashing with the jersey, mate.", "sawadeeka", "history", date, true),
        new Debate(12, "Hairy Maclary from Donaldson's Dairy and his hard yakka weka.", " cookie times are really beached as good with buzzy lengths of number 8 wire, aye. You have no idea how rip-off our mint Edmonds Cook Books were aye.", "sawadeeka", "music", date, true)
    };
    
    Rebuttal[] rebuttalsForTesting1 = {
        new Rebuttal(1, "TestTestTestContent", "cheesinForTheWeekend", 1, date, false),
        new Rebuttal(2, "TestTestTestConte", "snowOwl22", 1, date, true),
        new Rebuttal(3, "TestTestTestCont", "cheesinForTheWeekend", 1, date, false),
        new Rebuttal(4, "TestTestTestCon", "snowOwl22", 1, date, true),
        new Rebuttal(5, "TestTestTestCo", "cheesinForTheWeekend", 1, date, false),
        new Rebuttal(6, "TestTestTestC", "snowOwl22", 1, date, true),
        new Rebuttal(7, "TestTestTes", "cheesinForTheWeekend", 1, date, false),
        new Rebuttal(8, "TestTestT", "snowOwl22", 1, date, true)
        
        
    };
    
    Rebuttal[] rebuttalsForTesting2 = {
        new Rebuttal(9, "TestTestTestContent", "cheesinForTheWeekend", 2, date, false),
        new Rebuttal(10, "TestTestTestConte", "snowOwl22", 2, date, true),
        new Rebuttal(11, "TestTestTestCont", "cheesinForTheWeekend", 2, date, false),
        new Rebuttal(12, "TestTestTestCon", "snowOwl22", 2, date, true),
        new Rebuttal(13, "TestTestTestCo", "cheesinForTheWeekend", 2, date, false)
    };
    
    Rebuttal[] rebuttalsForTesting3 = {
        new Rebuttal(14, "TestTestTestC", "snowOwl22", 3, date, true),
        new Rebuttal(15, "TestTestTes", "cheesinForTheWeekend", 3, date, false),
        new Rebuttal(16, "TestTestT", "snowOwl22", 3, date, true)
    };
    
    @Test
    public void testAgainstEmptyDao(){
        junit.framework.Assert.assertNull("Asking for a nonexistent debate should return null", testDao.getDebateById(123));
        junit.framework.Assert.assertNotNull("List all debates shouldn't be null.", testDao.getAllDebates());
        junit.framework.Assert.assertEquals("Expectedd debate count of all published debates is nonzero against empty dao.", 0, testDao.getAllDebates().size());
    }
    
    @Test
    public void addOneToEmptyDaoTest(){
        
        Debate testDebate = new Debate(1, "Terrrrrrst Resolution.", "Some stuff in this test content.", "intro", "X2truDebatorX", "cheesinForTheWeekend", 0, 0, "music", date, true);
        testDebate.setRebuttals(rebuttals);
        Debate testCreatedDebate = testDao.createDebate(testDebate);
        Debate testDebateRetrieve = testDao.getDebateById(testDebate.getId());
        
        Assert.assertEquals(testDebate.getId(), testDebateRetrieve.getId());
        Assert.assertEquals(testDebate.getResolution(), testDebateRetrieve.getResolution());
        Assert.assertEquals(testDebate.getContent(), testDebateRetrieve.getContent());
        Assert.assertEquals(testDebate.getStatus(), testDebateRetrieve.getStatus());
        Assert.assertEquals(testDebate.getAffirmativeUser(), testDebateRetrieve.getAffirmativeUser());
        Assert.assertEquals(testDebate.getNegativeUser(), testDebateRetrieve.getNegativeUser());
        Assert.assertEquals(testDebate.getProVotes(), testDebateRetrieve.getProVotes());
        Assert.assertEquals(testDebate.getConVotes(), testDebateRetrieve.getConVotes());
        Assert.assertEquals(testDebate.getDate(), testDebateRetrieve.getDate());
        Assert.assertEquals(testDebate.getCategory(), testDebateRetrieve.getCategory());
        Assert.assertEquals(testDebate.isPublished(), testDebateRetrieve.isPublished());
        junit.framework.Assert.assertEquals("Debate stored does not match Debate retrieved.", testDebate, testDebateRetrieve);
        junit.framework.Assert.assertEquals("Returned debate does not match expected.", testDebate, testCreatedDebate);
        junit.framework.Assert.assertNotNull("List of all debates should not be null.", testDao.getAllDebates());
        junit.framework.Assert.assertEquals("Expected debate count of 'all debates' does not match after adding one debate.", 1, testDao.getAllDebates().size());
        junit.framework.Assert.assertTrue("Returned debate in getAllDebates does not match expected.", testDao.getAllDebates().contains(testDebate));
    }
    
    @Test
    public void addIntroDebateToEmptyDaoTest(){
        
        Debate testDebate = new Debate(1, "Terrrrrrst Resolution.", "Some stuff in this test content.", "X2truDebatorX", "music", date, false);
        testDebate.setRebuttals(rebuttals);
        Debate testCreatedDebate = testDao.createIntroDebate(testDebate);
        Debate testDebateRetrieve = testDao.getDebateById(testDebate.getId());
        
        Assert.assertEquals(testDebate.getId(), testDebateRetrieve.getId());
        Assert.assertEquals(testDebate.getResolution(), testDebateRetrieve.getResolution());
        Assert.assertEquals(testDebate.getContent(), testDebateRetrieve.getContent());
        Assert.assertEquals(testDebate.getAffirmativeUser(), testDebateRetrieve.getAffirmativeUser());
        Assert.assertEquals(testDebate.getCategory(), testDebateRetrieve.getCategory());
        Assert.assertEquals(testDebate.getDate(), testDebateRetrieve.getDate());
        Assert.assertEquals("intro", testDebate.getStatus());
        Assert.assertEquals("intro", testCreatedDebate.getStatus());
        Assert.assertEquals(true, testDebateRetrieve.isPublished());
        
        junit.framework.Assert.assertEquals("Expected dao size does not match size retrieved.", 1, testDao.getAllDebates().size());
        junit.framework.Assert.assertNotSame("Debate stored should not match Debate retrieved.", testDebate, testDebateRetrieve);
        junit.framework.Assert.assertEquals("Returned debate does not match expected.", testDebate, testCreatedDebate);
        junit.framework.Assert.assertNotNull("List of all debates should not be null.", testDao.getAllDebates());
        junit.framework.Assert.assertEquals("Expected debate count of 'all debates' does not match after adding one debate.", 1, testDao.getAllDebates().size());
        junit.framework.Assert.assertFalse("Returned debate in getAllDebates should not match expected.", testDao.getAllDebates().contains(testDebate));
    }
    
    
    
    @Test
    public void testUpdateDebate(){
        testDao.createDebate(debatesForTesting[0]);
        similarDebates[0].setId(debatesForTesting[0].getId());
        testDao.updateDebate(similarDebates[0]);
        Assert.assertEquals(similarDebates[0].getResolution(), testDao.getDebateById(similarDebates[0].getId()).getResolution());
        Assert.assertEquals(similarDebates[0].getContent(), testDao.getDebateById(similarDebates[0].getId()).getContent());
        Assert.assertEquals(similarDebates[0].getStatus(), testDao.getDebateById(similarDebates[0].getId()).getStatus());
        Assert.assertEquals(similarDebates[0].getAffirmativeUser(), testDao.getDebateById(similarDebates[0].getId()).getAffirmativeUser());
        Assert.assertEquals(similarDebates[0].getNegativeUser(), testDao.getDebateById(similarDebates[0].getId()).getNegativeUser());
        Assert.assertEquals(similarDebates[0].getProVotes(), testDao.getDebateById(similarDebates[0].getId()).getProVotes());
        Assert.assertEquals(similarDebates[0].getConVotes(), testDao.getDebateById(similarDebates[0].getId()).getConVotes());
        Assert.assertEquals(similarDebates[0].getCategory(), testDao.getDebateById(similarDebates[0].getId()).getCategory());
        Assert.assertEquals(similarDebates[0].getDate(), testDao.getDebateById(similarDebates[0].getId()).getDate());
        Assert.assertEquals(similarDebates[0].isPublished(), testDao.getDebateById(similarDebates[0].getId()).isPublished());
        junit.framework.Assert.assertEquals("Updated debate does not match expected", similarDebates[0], testDao.getDebateById(similarDebates[0].getId()));
        junit.framework.Assert.assertTrue("Returned debate in getAllDebates does not match expected.", testDao.getAllDebates().contains(similarDebates[0]));
        junit.framework.Assert.assertNotNull("List of all debates should not be null.", testDao.getAllDebates());
        junit.framework.Assert.assertEquals("Expected debate count of 'all debates' does not match after replacing one debate.", 1, testDao.getAllDebates().size());
    }
    
    @Test
    public void testUpdateIntroDebate(){
        testDao.createIntroDebate(introDebatesForTesting[0]);
        similarIntroDebates[0].setId(introDebatesForTesting[0].getId());
        testDao.updateDebate(similarIntroDebates[0]);
        Assert.assertEquals(similarIntroDebates[0].getResolution(), testDao.getDebateById(similarIntroDebates[0].getId()).getResolution());
        Assert.assertEquals(similarIntroDebates[0].getContent(), testDao.getDebateById(similarIntroDebates[0].getId()).getContent());
        Assert.assertEquals(similarIntroDebates[0].getStatus(), testDao.getDebateById(similarIntroDebates[0].getId()).getStatus());
        Assert.assertEquals(similarIntroDebates[0].getAffirmativeUser(), testDao.getDebateById(similarIntroDebates[0].getId()).getAffirmativeUser());
        Assert.assertEquals(similarIntroDebates[0].getNegativeUser(), testDao.getDebateById(similarIntroDebates[0].getId()).getNegativeUser());
        Assert.assertEquals(similarIntroDebates[0].getProVotes(), testDao.getDebateById(similarIntroDebates[0].getId()).getProVotes());
        Assert.assertEquals(similarIntroDebates[0].getConVotes(), testDao.getDebateById(similarIntroDebates[0].getId()).getConVotes());
        Assert.assertEquals(similarIntroDebates[0].getCategory(), testDao.getDebateById(similarIntroDebates[0].getId()).getCategory());
        Assert.assertEquals(similarIntroDebates[0].getDate(), testDao.getDebateById(similarIntroDebates[0].getId()).getDate());
        Assert.assertEquals(similarIntroDebates[0].isPublished(), testDao.getDebateById(similarIntroDebates[0].getId()).isPublished());
        junit.framework.Assert.assertNotSame("Updated debate does not match expected", similarIntroDebates[0], testDao.getDebateById(similarIntroDebates[0].getId()));
        junit.framework.Assert.assertNotNull("List of all debates should not be null.", testDao.getAllDebates());
        junit.framework.Assert.assertEquals("Expected debate count of 'all debates' does not match after replacing one debate.", 1, testDao.getAllDebates().size());
    }
    
    @Test
    public void testAddMultipleDebates(){
        for (Debate debate : debatesForTesting) {
            testDao.createDebate(debate);
            debate.setRebuttals(rebuttals);
        }
        junit.framework.Assert.assertNotNull("List of all debates should not be null.", testDao.getAllDebates());
        junit.framework.Assert.assertEquals("Expected debate count of 'all debates' does not match after adding several debates.",
                debatesForTesting.length, testDao.getAllDebates().size());
        for (Debate d : debatesForTesting){
            Assert.assertEquals(d.getResolution(), testDao.getDebateById(d.getId()).getResolution());
            Assert.assertEquals(d.getContent(), testDao.getDebateById(d.getId()).getContent());
            Assert.assertEquals(d.getStatus(), testDao.getDebateById(d.getId()).getStatus());
            Assert.assertEquals(d.getAffirmativeUser(), testDao.getDebateById(d.getId()).getAffirmativeUser());
            Assert.assertEquals(d.getNegativeUser(), testDao.getDebateById(d.getId()).getNegativeUser());
            Assert.assertEquals(d.getProVotes(), testDao.getDebateById(d.getId()).getProVotes());
            Assert.assertEquals(d.getConVotes(), testDao.getDebateById(d.getId()).getConVotes());
            Assert.assertEquals(d.getDate(), testDao.getDebateById(d.getId()).getDate());
            Assert.assertEquals(d.getCategory(), testDao.getDebateById(d.getId()).getCategory());
            Assert.assertEquals(d.isPublished(), testDao.getDebateById(d.getId()).isPublished());
            junit.framework.Assert.assertEquals("Returned debate does not match expected.", d, testDao.getDebateById(d.getId()));
            junit.framework.Assert.assertTrue("Returned debate in getAllDebates does not match expected.", testDao.getAllDebates().contains(d));
        }
    }
    
    @Test
    public void testAddMultipleIntroDebates(){
        for (Debate debate : introDebatesForTesting) {
            testDao.createIntroDebate(debate);
            debate.setRebuttals(rebuttals);
        }
        junit.framework.Assert.assertNotNull("List of all debates should not be null.", testDao.getAllDebates());
        junit.framework.Assert.assertEquals("Expected debate count of 'all debates' does not match after adding several debates.",
                introDebatesForTesting.length, testDao.getAllDebates().size());
        for (Debate d : introDebatesForTesting){
            Assert.assertEquals(d.getResolution(), testDao.getDebateById(d.getId()).getResolution());
            Assert.assertEquals(d.getContent(), testDao.getDebateById(d.getId()).getContent());
            Assert.assertEquals(d.getAffirmativeUser(), testDao.getDebateById(d.getId()).getAffirmativeUser());
            Assert.assertNull(testDao.getDebateById(d.getId()).getNegativeUser());
            Assert.assertEquals(0, testDao.getDebateById(d.getId()).getProVotes());
            Assert.assertEquals(0, testDao.getDebateById(d.getId()).getConVotes());
            Assert.assertEquals(d.getDate(), testDao.getDebateById(d.getId()).getDate());
            Assert.assertEquals(d.getCategory(), testDao.getDebateById(d.getId()).getCategory());
            junit.framework.Assert.assertNotSame("Returned debate should not match expected.", d, testDao.getDebateById(d.getId()));
        }
    }
    
    @Test
    public void testUpdateMultipleDebates(){
        for (Debate debate : debatesForTesting) {
            testDao.createDebate(debate);
            debate.setRebuttals(rebuttals);
        }
        for (int i = 0; i < debatesForTesting.length; i++) {
            similarDebates[i].setId(debatesForTesting[i].getId());
            testDao.updateDebate(similarDebates[i]);
        }
        junit.framework.Assert.assertNotNull("List of debates shouldn't be null.", testDao.getAllDebates());
        junit.framework.Assert.assertEquals("Expected debate count does not match after updated debates.", debatesForTesting.length, testDao.getAllDebates().size());
        for (Debate d : similarDebates){
            Assert.assertEquals(d.getResolution(), testDao.getDebateById(d.getId()).getResolution());
            Assert.assertEquals(d.getContent(), testDao.getDebateById(d.getId()).getContent());
            Assert.assertEquals(d.getStatus(), testDao.getDebateById(d.getId()).getStatus());
            Assert.assertEquals(d.getAffirmativeUser(), testDao.getDebateById(d.getId()).getAffirmativeUser());
            Assert.assertEquals(d.getNegativeUser(), testDao.getDebateById(d.getId()).getNegativeUser());
            Assert.assertEquals(d.getProVotes(), testDao.getDebateById(d.getId()).getProVotes());
            Assert.assertEquals(d.getConVotes(), testDao.getDebateById(d.getId()).getConVotes());
            Assert.assertEquals(d.getDate(), testDao.getDebateById(d.getId()).getDate());
            Assert.assertEquals(d.getCategory(), testDao.getDebateById(d.getId()).getCategory());
            Assert.assertEquals(d.isPublished(), testDao.getDebateById(d.getId()).isPublished());
            junit.framework.Assert.assertEquals("Returned debate does not match expected.", d, testDao.getDebateById(d.getId()));
            junit.framework.Assert.assertTrue("Returned debate in getAllDebates does not match expected.", testDao.getAllDebates().contains(d));
        }
    }
    
    @Test
    public void testUpdateMultipleIntroDebates(){
        for (Debate debate : introDebatesForTesting) {
            testDao.createIntroDebate(debate);
            debate.setRebuttals(rebuttals);
        }
        for (int i = 0; i < similarDebates.length; i++) {
            similarDebates[i].setId(introDebatesForTesting[i].getId());
            testDao.updateDebate(similarDebates[i]);
        }
        junit.framework.Assert.assertNotNull("List of debates shouldn't be null.", testDao.getAllDebates());
        junit.framework.Assert.assertEquals("Expected debate count does not match after updated debates.", introDebatesForTesting.length, testDao.getAllDebates().size());
        for (int j = 1; j < similarDebates.length; j++){
            Assert.assertEquals(similarDebates[j].getResolution(), testDao.getDebateById(similarDebates[j].getId()).getResolution());
            Assert.assertEquals(similarDebates[j].getContent(), testDao.getDebateById(similarDebates[j].getId()).getContent());
            Assert.assertEquals(similarDebates[j].getStatus(), testDao.getDebateById(similarDebates[j].getId()).getStatus());
            Assert.assertEquals(similarDebates[j].getAffirmativeUser(), testDao.getDebateById(similarDebates[j].getId()).getAffirmativeUser());
            Assert.assertEquals(similarDebates[j].getNegativeUser(), testDao.getDebateById(similarDebates[j].getId()).getNegativeUser());
            Assert.assertEquals(similarDebates[j].getProVotes(), testDao.getDebateById(similarDebates[j].getId()).getProVotes());
            Assert.assertEquals(similarDebates[j].getConVotes(), testDao.getDebateById(similarDebates[j].getId()).getConVotes());
            Assert.assertEquals(similarDebates[j].getDate(), testDao.getDebateById(similarDebates[j].getId()).getDate());
            Assert.assertEquals(similarDebates[j].getCategory(), testDao.getDebateById(similarDebates[j].getId()).getCategory());
            Assert.assertEquals(similarDebates[j].isPublished(), testDao.getDebateById(similarDebates[j].getId()).isPublished());
            junit.framework.Assert.assertEquals("Returned debate does not match expected.", similarDebates[j], testDao.getDebateById(similarDebates[j].getId()));
            junit.framework.Assert.assertTrue("Returned debate in getAllDebates does not match expected.", testDao.getAllDebates().contains(similarDebates[j]));
        }
    }
    
    @Test
    public void testAddSimilarDebates() {
        for (Debate debate : debatesForTesting) {
            testDao.createDebate(debate);
        }
        for (Debate debate : similarDebates) {
            testDao.createDebate(debate);
        }
        junit.framework.Assert.assertNotNull("List of all debates should not be null.", testDao.getAllDebates());
        junit.framework.Assert.assertEquals("Expected debate count does not match after adding several similar debates.",
                debatesForTesting.length + similarDebates.length, testDao.getAllDebates().size());
        junit.framework.Assert.assertEquals("Expected debate count of 'all debates' does not match after adding several similar debates.",
                debatesForTesting.length + similarDebates.length, testDao.getAllDebates().size());
        for (int i = 0; i < similarDebates.length; i++) {
            junit.framework.Assert.assertEquals("Get debate does not match expected return on addition of similar debate.", similarDebates[i],
                    testDao.getDebateById(similarDebates[i].getId()));
            junit.framework.Assert.assertTrue("Returned debate in getAllDebates does not match expected.", testDao.getAllDebates().contains(similarDebates[i]));
        }
        for (int i = 0; i < debatesForTesting.length; i++) {
            junit.framework.Assert.assertEquals("Get debate does not match expected return on addition of similar debate.", debatesForTesting[i],
                    testDao.getDebateById(debatesForTesting[i].getId()));
            junit.framework.Assert.assertTrue("Returned debate in getAllDebates does not match expected.", testDao.getAllDebates().contains(debatesForTesting[i]));
        }
    }

    @Test
    public void testAddAndRemoveOneDebate() {
        testDao.createDebate(debatesForTesting[0]);
        testDao.deleteDebate(debatesForTesting[0].getId());
        junit.framework.Assert.assertNotNull("List of all debates should not be null.", testDao.getAllDebates());
        junit.framework.Assert.assertNull("Get debate should return null after being removed.", testDao.getDebateById(debatesForTesting[0].getId()));
        junit.framework.Assert.assertEquals("Expected debate count of 'all debates' should be zero when adding/removing a single debate.", 0, testDao.getAllDebates().size());
    }

    @Test
    public void testAddAndRemoveDebateTwice() {
        testDao.createDebate(debatesForTesting[0]);
        testDao.deleteDebate(debatesForTesting[0].getId());
        testDao.deleteDebate(debatesForTesting[0].getId());
        junit.framework.Assert.assertNotNull("List of all debates should not be null.", testDao.getAllDebates());
        junit.framework.Assert.assertNull("Debate should return null after being removed.", testDao.getDebateById(debatesForTesting[0].getId()));
        junit.framework.Assert.assertEquals("Expected debate count of 'all debates' should be zero when adding/removing a single debate twice.", 0, testDao.getAllDebates().size());
    }

    @Test
    public void testAddAndRemoveMultipleDebates() {
        for (Debate debate : debatesForTesting) {
            testDao.createDebate(debate);
        }
        int debatesAdded = debatesForTesting.length;
        for (int i = 0; i < debatesForTesting.length; i += 2) {
            testDao.deleteDebate(debatesForTesting[i].getId());
            debatesAdded--;
        }
        junit.framework.Assert.assertNotNull("List of all debates should not be null.", testDao.getAllDebates());
        junit.framework.Assert.assertEquals("Expected debate count of 'all debates' does not match after adding & removing several debates.",
                debatesAdded, testDao.getAllDebates().size());
        for (int i = 0; i < debatesForTesting.length; i++) {
            if (i % 2 == 1) {
                junit.framework.Assert.assertEquals("Returned debate does not match expected.", debatesForTesting[i], testDao.getDebateById(debatesForTesting[i].getId()));
            } else {
                junit.framework.Assert.assertNull("Debate should be removed and return null.", testDao.getDebateById(debatesForTesting[i].getId()));
            }
        }
    }

    @Test
    public void testAddAndRemoveDebatesMultipleTimes() {
        for (Debate debate : debatesForTesting) {
            testDao.createDebate(debate);
        }
        for (Debate debate : debatesForTesting) {
            testDao.deleteDebate(debate.getId());
        }
        for (Debate debate : debatesForTesting) {
            testDao.createDebate(debate);
        }
        junit.framework.Assert.assertNotNull("List of all debates should not be null.", testDao.getAllDebates());
        junit.framework.Assert.assertEquals("Expected debate count of 'all debates' should be zero when adding/removing a all debates.",
                debatesForTesting.length, testDao.getAllDebates().size());
        for (int i = 0; i < debatesForTesting.length; i++) {
            Debate debate = debatesForTesting[i];
            junit.framework.Assert.assertEquals("Debate should return after being re-added.", debate, testDao.getDebateById(debate.getId()));
            testDao.deleteDebate(debate.getId());
            junit.framework.Assert.assertNull("Debate should return null after being removed.", testDao.getDebateById(debate.getId()));
        }
        junit.framework.Assert.assertEquals("Expected debate count of 'all debates' should be zero when adding/removing a all debates.", 0, testDao.getAllDebates().size());
    }

    @Test
    public void testDebateCountOnAddition() {
        // Add all debates and check that count increments appropriately
        for (int i = 0; i < debatesForTesting.length; i++) {
            testDao.createDebate(debatesForTesting[i]);
            junit.framework.Assert.assertEquals("Expected " + (i + 1) + " debates after adding debates.",
                    i + 1, testDao.getAllDebates().size());
        }
    }

    @Test
    public void testDebateCountOnUpdate() {
        // Add all debates and check that count increments appropriately
        for (int i = 0; i < debatesForTesting.length; i++) {
            testDao.createDebate(debatesForTesting[i]);
            similarDebates[i].setId(debatesForTesting[i].getId());
            testDao.updateDebate(similarDebates[i]);
            junit.framework.Assert.assertEquals("Expected " + (i + 1) + " debates after updating debates.",
                    i + 1, testDao.getAllDebates().size());
        }
    }

    @Test
    public void testDebateCountAfterRemoval() {
        // Add all debates
        for (int i = 0; i < debatesForTesting.length; i++) {
            testDao.createDebate(debatesForTesting[i]);
        }
        // Remove debates one by one and test that count decrements properly
        for (int i = 0; i < debatesForTesting.length; i++) {
            testDao.deleteDebate(debatesForTesting[i].getId());
            junit.framework.Assert.assertEquals("Expected " + (debatesForTesting.length - i - 1) + " debates after removing debates.",
                    debatesForTesting.length - i - 1, testDao.getAllDebates().size());
        }
    }

    @Test
    public void testDebatesAfterRemovalOfNonExistent() {
        // Add all debates
        for (int i = 0; i < debatesForTesting.length; i++) {
            testDao.createDebate(debatesForTesting[i]);
        }
        testDao.deleteDebate(100);
        junit.framework.Assert.assertEquals("Expected " + debatesForTesting.length + " debates after removing debates.",
                debatesForTesting.length, testDao.getAllDebates().size());
    }

    @Test
    public void testDebateCountAfterTwiceRemoved() {
        // Add all debates
        for (int i = 0; i < debatesForTesting.length; i++) {
            testDao.createDebate(debatesForTesting[i]);
        }
        // Remove debates one by one and test that count decrements properly
        for (int i = 0; i < debatesForTesting.length; i++) {
            testDao.deleteDebate(debatesForTesting[i].getId());
        }
        junit.framework.Assert.assertEquals("Expected " + 0 + " debates after removing debates.",
                0, testDao.getAllDebates().size());
        // Remove debates one by one and test that count decrements properly
        for (int i = 0; i < debatesForTesting.length; i++) {
            testDao.deleteDebate(debatesForTesting[i].getId());
        }
        junit.framework.Assert.assertEquals("Expected " + 0 + " debates after attempting to re-remove debates.",
                0, testDao.getAllDebates().size());
    }
    
    @Test
    public void testAddRebuttalToEmptyDaoTest() {
        Debate testDebate = new Debate(1, "Terrrrrrst Resolution.", "Some stuff in this test content.", "intro", "X2truDebatorX", "cheesinForTheWeekend", 0, 0, "music", date, true);
        testDao.createDebate(testDebate);
        Rebuttal testRebuttal = new Rebuttal(1, "TestTestTestContent", "cheesinForTheWeekend", testDebate.getId(), date, false);
        testDao.createRebuttal(testRebuttal);

        Rebuttal testRebuttalRetrieve = testDao.getDebateById(testDebate.getId()).getRebuttals().get(0);
        Assert.assertEquals(testRebuttal, testRebuttalRetrieve);

        Assert.assertEquals(testRebuttal.getId(), testRebuttalRetrieve.getId());
        Assert.assertEquals(testRebuttal.getContent(), testRebuttalRetrieve.getContent());

        junit.framework.Assert.assertEquals("Rebuttal stored, vs. rebuttal retrieved does not match",
                testRebuttal, testRebuttalRetrieve);
    }
    
    @Test
    public void testAddMaxRebuttalsOnADebate(){
        Debate testDebate = new Debate(1, "Terrrrrrst Resolution.", "Some stuff in this test content.", "intro", "X2truDebatorX", "cheesinForTheWeekend", 0, 0, "music", date, true);
        testDao.createDebate(testDebate);
        for(Rebuttal r : rebuttalsForTesting1){
            r.setDebateId(testDebate.getId());
            testDao.createRebuttal(r);
        }
        Assert.assertEquals(5, testDao.getDebateById(testDebate.getId()).getRebuttals().size());
        Assert.assertEquals("voting", testDao.getDebateById(testDebate.getId()).getStatus());
    }
    
    @Test
    public void testGetRebuttalById(){
        for (int i = 0; i < 3; i++) {
            testDao.createDebate(debatesForTesting[i]);
        }
        rebuttalsForTesting1[0].setDebateId(debatesForTesting[0].getId());
        Rebuttal rebTest = testDao.createRebuttal(rebuttalsForTesting1[0]);
        
        Rebuttal reb = testDao.getRebuttalById(rebTest.getId());
        Assert.assertEquals("Rebuttal does not match returned rebuttal.", rebTest, reb);
    }
    
    @Test
    public void testUpdateRebuttal(){
        testDao.createDebate(debatesForTesting[3]);
        rebuttalsForTesting1[0].setDebateId(debatesForTesting[3].getId());
        testDao.createRebuttal(rebuttalsForTesting1[0]);
        Assert.assertEquals("Content of rebuttal does not match after adding rebuttal to dao", rebuttalsForTesting1[0].getContent(),
                testDao.getRebuttalById(rebuttalsForTesting1[0].getId()).getContent());
        rebuttalsForTesting1[1].setId(rebuttalsForTesting1[0].getId());
        testDao.updateRebuttal(rebuttalsForTesting1[1]);
        Assert.assertEquals("Content of rebuttal does not match after updating rebuttal to dao", rebuttalsForTesting1[1].getContent(),
                testDao.getRebuttalById(rebuttalsForTesting1[0].getId()).getContent());
        
    }
    
    @Test
    public void testSearchDebatesByResolution(){
        
        for (Debate debate : debatesForTesting) {
            if (debate.isPublished()){
                testDao.createDebate(debate);
                debate.setRebuttals(rebuttals);
            }
        }
        junit.framework.Assert.assertNotNull("List of all debates should not be null.", testDao.getAllDebates());
        //the -2 are the unpublished debates
        junit.framework.Assert.assertEquals("Expected debate count of 'all debates' does not match after adding several debates.",
                debatesForTesting.length-2, testDao.getAllPublishedDebates().size());
        testSearchDebateResults = testDao.searchDebatesByResolution(debatesForTesting[0].getResolution());
        Assert.assertTrue(testSearchDebateResults.contains(debatesForTesting[0]));
        //tests every debate for every resolution string combination in search
        for (int k = 0; k < testDao.getAllPublishedDebates().size()-1; k++) {
            String resolution = debatesForTesting[k].getResolution();
            String subRes;
            for (int i = 0; i < resolution.length()-1; i++) {
                for (int j = i+1; j < resolution.length()-1; j++) {
                    subRes = resolution.substring(i, j);
                    testSearchDebateResults = testDao.searchDebatesByResolution(subRes);
                    Assert.assertTrue(testSearchDebateResults.contains(debatesForTesting[k]));
                }
            }
        }
    }
    
    @Test
    public void testSearchDebatesByCategory(){
        for (Debate debate : debatesForTesting) {
            if (debate.isPublished()){
                testDao.createDebate(debate);
                debate.setRebuttals(rebuttals);
            }
        }
        for (Debate d : testDao.getAllPublishedDebates()) {
            String category = d.getCategory();
            testSearchDebateResults = testDao.searchDebatesByCategory(category);
            Assert.assertTrue(testSearchDebateResults.contains(d));
        }
    }
    
    @Test
    public void testSearchDebatesByUsers(){
        for (Debate debate : debatesForTesting) {
            if (debate.isPublished()){
                testDao.createDebate(debate);
                debate.setRebuttals(rebuttals);
            }
        }
        //search by affirmative user
        for (Debate d : testDao.getAllPublishedDebates()) {
            String affUser = d.getAffirmativeUser();
            testSearchDebateResults = testDao.searchDebatesByUser(affUser);
            Assert.assertTrue(testSearchDebateResults.contains(d));
        }
        //search by negative user
        for (Debate d : testDao.getAllPublishedDebates()) {
            String negUser = d.getNegativeUser();
            testSearchDebateResults = testDao.searchDebatesByUser(negUser);
            Assert.assertTrue(testSearchDebateResults.contains(d));
        }
    }
    
    @Test
    public void testSearchDebateByDate(){
        for (Debate debate : debatesForTesting) {
            if (debate.isPublished()){
                testDao.createDebate(debate);
                debate.setRebuttals(rebuttals);
            }
        }
        for (Debate d : testDao.getAllPublishedDebates()) {
            String testDate = d.getDate();
            testSearchDebateResults = testDao.searchDebatesByDate(testDate);
            Assert.assertTrue(testSearchDebateResults.contains(d));
        }
    }


}
    

//    /**
//     * Test of getAllCategories method, of class DebateDaoImpl.
//     */
//    @Test
//    public void testGetAllCategories() {
//        System.out.println("getAllCategories");
//        DebateDaoImpl instance = new DebateDaoImpl();
//        List<String> expResult = null;
//        List<String> result = instance.getAllCategories();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

