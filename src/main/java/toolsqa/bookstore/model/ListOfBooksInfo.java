package toolsqa.bookstore.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
public class ListOfBooksInfo {
    public String userId;
    public List<CollectionOfIsbn> collectionOfIsbns;

    public ListOfBooksInfo(String userId, List<CollectionOfIsbn> collectionOfIsbns){
        this.userId = userId;
        this.collectionOfIsbns = collectionOfIsbns;
    }
}
