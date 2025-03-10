import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {

  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testFilter() {
    List<String> list1 = Arrays.asList("burh", "honeymoon", "moon");
    List<String> expected1 = Arrays.asList("moon");
    List<String> list2 = Arrays.asList("burh", "honeymoon", "moon", "gang", "moon");
    List<String> expected2 = Arrays.asList("moon", "moon");
    assertEquals(ListExamples.filter(list1, new IsMoon()), expected1);
    assertEquals(ListExamples.filter(list2, new IsMoon()), expected2);
  }
}
