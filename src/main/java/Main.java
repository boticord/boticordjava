import com.fasterxml.jackson.core.JsonProcessingException;
import com.meilisearch.sdk.exceptions.MeilisearchException;
import org.boticordjava.api.entity.users.usercommentsearch.UsersCommentSearch;
import org.boticordjava.api.impl.BotiCordAPI;

import java.util.List;

public class Main {

    public static void main(String[] args) throws MeilisearchException, JsonProcessingException {
        BotiCordAPI api = new BotiCordAPI.Builder()
                .token("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjI1MDY5OTI2NTM4OTYyNTM0NyIsInRva2VuIjoibHZoVmhBODFGREk3QTJISWMwRWk4UlZSNUNyRFRIZlhOck5EVDRyOUwyNGcxZWI5ek9KbGE5eGUzMGQ3MGFFSCIsInJlZGlyZWN0Ijoi0YLRiyDQtNGD0LzQsNC7INGC0YPRgiDRh9GC0L4t0YLQviDQsdGD0LTQtdGCPyIsInBlcm1pc3Npb25zIjowLCJ0eXBlIjoiYm90IiwiaWF0IjoxNzA0NTQwNTY2fQ.RZIxV9QodUXSc2JdYkgVLY6qBc11CMcXGweBqzXu-UI")
                .enableDevMode()
                .build();

        List<UsersCommentSearch> serversSearches = api.searchUserComments("405258156063850497");


        System.out.println(serversSearches.size());
    }
}
