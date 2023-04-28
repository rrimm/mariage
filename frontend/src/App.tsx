import GlobalStyle from './styles/global';
import RangeMultiSlider_M from './components/RangeMultiSlider_M/RangeMultiSlider_M'
import RangeMultiSlider_F from './components/RangeMultiSlider_F/RangeMultiSlider_F';
import ProductCard from './components/ProductCard/ProductCard';

function App() {
  return (
    <>
      <GlobalStyle />
      {/* <p>IBM 마리아주 1 2 3 4 5 6 7 8 9 0</p>
      <button>버튼</button>
      <h1>Mariage</h1>
      <h2>Mariage</h2>
      <h3>Mariage</h3> */}
      <RangeMultiSlider_M
        min={0}
        max={1000}
        onChange={({ min, max }: { min: number; max: number }) =>
          console.log(`min = ${min}, max = ${max}`)
        }
      />
      <RangeMultiSlider_F
        min={0}
        max={70}
        onChange={({ min, max }: { min: number; max: number }) =>
          console.log(`min = ${min}, max = ${max}`)
        }
      />
      <ProductCard />
    </>
  );
}

export default App;
