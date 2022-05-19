public class Labela4 {
	 public static void main(String args[]) {
		 System.out.println("Ïðîãðàìà äëÿ ïðåîáðàçîâàíèÿ ãðàäóñîâ â ðàäèàíû");
		 // данные на которые опирается наша нейронная сеть(Учитель)
		 double[] Degrees = { 1,5,13,23,28,48,67};                     // данные в градусах и
		 double[] Radians = { 0.0174533,0.0872665,0.226893,0.401426,0.488692,0.837758,1.16937};//  конвертация в радианы
		 
		 NeuralNetwork n = new NeuralNetwork();
		   int r = (int) (Math.random()*7);//выбираем любое из 7 значение и по нему обучаемся
		   int i = 0;
		   int i = 0;
		   while ((n.Error > n.speed)||(n.Error < -n.speed))
		    {
		        i++;
		        n.NeuronTraining(Degrees[r], Radians[r]);
		        if (i % 10000000 == 0)       //для того чтобы выводила каждую 10 000 000, а не все значения
		        {
		        	 System.out.println("Error number: "+i+" Radians:"+ n.Error);
		        }
		    }
		 
		  System.out.println("\n");
                    n.ResultCalcNeurons(666);
		    n.ReverseOutput(10);
		    n.ResultCalcNeurons(14);
		    n.ReverseOutput(666);
		    n.ResultCalcNeurons(312);
		    n.ReverseOutput(234);
		 }
	}
	class NeuralNetwork{
		public
		double weight = Math.random() * 3; 
		double Error=-0.000001;//
		double speed=0.00000001;// скорость обучения нейрона
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

