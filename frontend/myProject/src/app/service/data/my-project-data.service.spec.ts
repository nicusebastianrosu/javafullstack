import { TestBed } from '@angular/core/testing';

import { MyProjectDataService } from './my-project-data.service';

describe('MyProjectDataService', () => {
  let service: MyProjectDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MyProjectDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
