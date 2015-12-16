package cn.test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ShardedJedis;
import cn.RedisUtil;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<HostAndPort> nodes=new HashSet<HostAndPort>();
		nodes.add(new HostAndPort("127.0.0.1", 7000));
		JedisCluster jc = new JedisCluster(nodes);
		System.out.println(jc.get("foo"));
		List<String> range = jc.lrange("data", 0, -1);
		System.out.println(range.size());
		String data = jc.getrange("foo", 0, 1);
		System.out.println(data);
		
	}

}
