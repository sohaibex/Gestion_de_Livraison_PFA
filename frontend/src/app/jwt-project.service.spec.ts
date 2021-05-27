import { TestBed } from '@angular/core/testing';

import { JwtProjectService } from './jwt-project.service';

describe('JwtProjectService', () => {
  let service: JwtProjectService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(JwtProjectService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
