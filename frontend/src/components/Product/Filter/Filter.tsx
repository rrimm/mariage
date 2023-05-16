import { useState } from 'react';

import RangeMultiSlider_F from '@/components/Slider/RangeMultiSlider_F/RangeMultiSlider_F';

import { Range } from '@/@types/slider';

import * as S from './Filter.styled';

type FilterProps = {
  count: number;
};

type Option = {
  rate: Range;
  level: Range;
};

function Filter({ count }: FilterProps) {
  /*TODO: 현재는 임시 데이터 이지만 추후에는 서버의 데이터를 사용, Recoil에 저장하는 형식이 좋을 듯 보입니다.  */
  const category = [
    '스카치',
    '아메리칸 ·버번',
    '몰트',
    '아이리시',
    '그레인',
    '포트',
  ];

  const [option, setOption] = useState<Option>({
    rate: {
      max: 50,
      min: 0,
    },
    level: {
      max: 70,
      min: 0,
    },
  });

  const changeRateOption = (selectRateRange: Range) => {
    setOption({ ...option, rate: selectRateRange });
  };

  const changeLevelOption = (selectLevelRange: Range) => {
    setOption({ ...option, level: selectLevelRange });
  };

  return (
    <S.Container>
      <p>조회한 상품 개수는 {count}개 입니다.</p>
      <S.FilterWrap>
        <h4>필터</h4>
        <S.CategoryWrap>
          <p>종류</p>
          {category.map(function (a, i) {
            return <S.Category>{category[i]}</S.Category>;
          })}
        </S.CategoryWrap>
        <S.RangeWrap>
          <S.Star>
            별점
            <RangeMultiSlider_F
              min={0}
              max={5}
              onChange={({ min, max }: { min: number; max: number }) =>
                changeRateOption({
                  max: max,
                  min: min,
                })
              }
            />
          </S.Star>

          <S.ABV>
            알코올 도수(%, ABV)
            <RangeMultiSlider_F
              min={0}
              max={70}
              onChange={({ min, max }: { min: number; max: number }) =>
                changeLevelOption({
                  max: max,
                  min: min,
                })
              }
            />
          </S.ABV>
        </S.RangeWrap>
        <S.FilterBtn>필터적용</S.FilterBtn>
      </S.FilterWrap>
    </S.Container>
  );
}

export default Filter;