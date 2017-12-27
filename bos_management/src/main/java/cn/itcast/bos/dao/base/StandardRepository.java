package cn.itcast.bos.dao.base;

import cn.itcast.bos.domain.base.Standard;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Administrator on 2017/12/23.
 */
public interface StandardRepository extends JpaRepository<Standard,Integer> {

    public List<Standard> findByName(String name);
    @Query(value = "from Standard where name = ? ",nativeQuery = false)
    public List<Standard> queryByName(String name);


    @Query(value = "update Standard set minLength = ?2 where id = ?1")
    @Modifying
    public void updateMinLength(Integer id,Integer minLength);


    public Page<Standard> findPageData(Pageable pageable);
}
