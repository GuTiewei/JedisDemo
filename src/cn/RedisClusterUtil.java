package cn;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class RedisClusterUtil {

	private static Set<HostAndPort> nodes = null;
	private static JedisCluster jc = null;
	
	private static String[]hosts = new String[]{"127.0.0.1","127.0.0.1","127.0.0.1","127.0.0.1","127.0.0.1","127.0.0.1"};
	private static int[]ports = new int[]{7000,7001,7002,8000,8001,8002};
	static {
		nodes = new HashSet<>();
		for(int i=0;i<ports.length;i++)
			nodes.add(new HostAndPort(hosts[i], ports[i]));
		jc = new JedisCluster(nodes);
	}
	
	public static JedisCluster getCluster(){
		return jc;
	}
}
