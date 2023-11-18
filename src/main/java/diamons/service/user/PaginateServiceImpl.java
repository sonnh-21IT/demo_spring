package diamons.service.user;

import diamons.DTO.PaginateDTO;
import org.springframework.stereotype.Service;

@Service
public class PaginateServiceImpl implements IPaginateService {

    @Override
    public PaginateDTO getInfoPaginate(int totalData, int limit, int currentPage) {
        PaginateDTO paginate = new PaginateDTO();
        paginate.setLimit(limit);

        paginate.setTotalPage(setInfoTotalPage(totalData, limit));
        paginate.setCurrentPage(checkCurrentPage(currentPage, paginate.getTotalPage()));

        int start = findStart(paginate.getCurrentPage(), limit);
        paginate.setStart(start);
        int end = findEnd(paginate.getStart(), limit, totalData);
        paginate.setEnd(end);

        return paginate;
    }

    private int findEnd(int start, int limit, int totalData) {
        return (start + limit) > totalData ? totalData : (start + limit) - 1;
    }

    private int findStart(int currentPage, int limit) {
        return ((currentPage - 1) * limit) + 1;
    }

    private int setInfoTotalPage(int totalData, int limit) {
        int totalPage = 0;
        totalPage = totalData / limit;
        totalPage = totalPage * limit < totalData ? totalPage + 1 : totalPage;
        return totalPage;
    }

    public int checkCurrentPage(int currentPage, int totalPage) {
        if (currentPage < 1) {
            return 1;
        }
        return Math.min(currentPage, totalPage);
    }
}
