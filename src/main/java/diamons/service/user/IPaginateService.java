package diamons.service.user;

import diamons.DTO.PaginateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface IPaginateService {
    @Autowired
    PaginateDTO getInfoPaginate(int totalData, int limit, int currentPage);
}
