import { MyApPage } from './app.po';

describe('my-ap App', () => {
  let page: MyApPage;

  beforeEach(() => {
    page = new MyApPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
