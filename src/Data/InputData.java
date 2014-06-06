package Data;

import java.util.ArrayList;

public class InputData
{
	ArrayList<Integer> data = new ArrayList<Integer>();
	public InputData(int ...element)
	{
		data.removeAll(data);
		for(int elements : element)
		{
			data.add(elements);
		}
	}
}
