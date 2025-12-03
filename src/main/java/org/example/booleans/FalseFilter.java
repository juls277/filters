package org.example.booleans;
import org.example.Filter;
import java.util.Map;
public class FalseFilter implements Filter {
    @Override
    public boolean matches(Map<String, String> resource) {
        return false;
    }
}
