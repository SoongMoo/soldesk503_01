package repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.CartDTO;
import model.GoodsDTO;
import model.WishDTO;

@Repository
public class GoodsRepository {
	@Autowired
	private SqlSession sqlSession;
	private final String namespace="goodsMapper";
	public Integer goodsDelete(GoodsDTO dto) {
		String statement = namespace + ".goodsDelete";
		return sqlSession.delete(statement, dto);
	}
	public List<GoodsDTO> goodsWishList(String userId){
		String statement = namespace + ".goodsWishList";
		return sqlSession.selectList(statement, userId);
	}
	public Integer wishAdd(WishDTO dto) {
		String statement = namespace + ".wishAdd";
		sqlSession.update(statement, dto);
		statement = namespace + ".wishCount";
		return sqlSession.selectOne(statement, dto);
	}
	public void goodsCartQtyDown(Long cartNum) {
		String statement = namespace + ".goodsCartQtyDown";
		sqlSession.update(statement, cartNum);
	}
	public void goodsCartRemove(Map<String, Object> condition) {
		String statement = namespace + ".goodsCartRemove";
		sqlSession.delete(statement, condition);
	}
	public List<CartDTO> cartList(String userId){
		String statement = namespace + ".cartList";
		return sqlSession.selectList(statement,userId);
	}	
	public Integer goodsCartAdd(CartDTO cart) {
		String statement = namespace+ ".goodsCartAdd";
		return sqlSession.insert(statement, cart);		
	}
	public GoodsDTO goodsDetail(GoodsDTO dto) {
		String statement = namespace+ ".getGoodsList";
		return sqlSession.selectOne(statement, dto);		
	}
	public Integer getGoodsCount(){
		String statement = namespace+ ".getGoodsCount";
		return sqlSession.selectOne(statement);
	}
	public List<GoodsDTO> getGoodsList(GoodsDTO dto){
		String statement = namespace+ ".getGoodsList";
		return sqlSession.selectList(statement, dto);
	}
	public void goodsInsert(GoodsDTO dto) {
		String statement = namespace+ ".goodsInsert";
		sqlSession.insert(statement, dto);
	}
	
}
