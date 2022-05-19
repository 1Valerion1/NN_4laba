public class Labela4 {
	 public static void main(String args[]) {
		 System.out.println("Програма для преобразования градусов в радианы");
		 // данные на которые опирается наша нейронная сеть(Учитель)
		 double[] Degrees = { 1,7,13,15,28,45 };                      // данные в градусах и
		 double[] Radians = { 0.0174533,0.122173,0.226893,0.261799,0.488692,0.785398 };//  конвертация в радианы
		 
		 NeuralNetwork n = new NeuralNetwork();
		   int r = (int) (Math.random()*6);//выбираем любое из значение и по нему обучаемся
		   int i = 0;
		   while ((n.Error > n.speed)||(n.Error < -n.speed))
		    {
		        i++;
		        n.NeuronTraining(Degrees[r], Radians[r]);
		        if (i % 10000000 == 0)       // 
		        {
		        	 System.out.println("Error number: "+i+" Radians:"+ n.Error);
		        }
		    }
		 
		 // System.out.println("\n");
		    n.ResultCalcNeurons(15);
		    n.ReverseOutput(1);
		    n.ResultCalcNeurons(40);
		    n.ReverseOutput(50);
		    n.ResultCalcNeurons(3);
		    n.ReverseOutput(356);
		 }
	}
	class NeuralNetwork{
		public
		double weight = Math.random() * 3; //переписать
		double Error=-0.0001;//
		double speed=0.00000001;//  скорость обучения нейрона
		double result;

		 public void ResultCalcNeurons(double input)//вывод значений в результатов расчета нейрона(градусы->радианы)
		{
			 System.out.println((int)input+" degress eqals: "+input*weight+" radians");
		}
		 
		public void ReverseOutput(double output)//обратный вывод из радиан->градусы(выход/вес)
		{
			System.out.println((int)output+" radians equals "+output/weight+" degrees");
		}
		 
		public void NeuronTraining(double input, double output)//Тренировка(градусы/радианы)
		{
			double InterResult,correct;//результат на данный момент и размер нужной корректировки
			
			InterResult= input*weight;
			Error= output-InterResult;//размер ошибки
			correct=(Error/InterResult)*speed;
			weight=weight+correct;// изменение веса на размер корректировки
		}
	}

